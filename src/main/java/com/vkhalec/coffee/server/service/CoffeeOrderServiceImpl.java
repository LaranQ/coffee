package com.vkhalec.coffee.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.vkhalec.coffee.client.CoffeeMachineService;
import com.vkhalec.coffee.client.CoffeeOrderService;
import com.vkhalec.coffee.client.CoffeeService;
import com.vkhalec.coffee.shared.Coffee;
import com.vkhalec.coffee.shared.CoffeeMachine;
import com.vkhalec.coffee.shared.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.vkhalec.coffee.server.dao.CoffeeOrderRepository;
import com.vkhalec.coffee.server.exception_handling.CoffeeException;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeOrderServiceImpl
        extends RemoteServiceServlet
        implements CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository repository;

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeMachineService coffeeMachineService;

    public CoffeeOrderServiceImpl() {
    }

    @Override
    public List<CoffeeOrder> getAllCoffeeOrder() {
        return repository.findAll();
    }

    @Override
    public CoffeeOrder getCoffeeOrder(int id) {
        Optional<CoffeeOrder> optional = repository.findById(id);

        if (optional.isPresent())
            return optional.get();

        throw new CoffeeException("Заказа с таким id не существует.");
    }

    @Override
    public boolean isExist(Integer id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public CoffeeOrder saveCoffeeOrder(CoffeeOrder coffeeOrder) {

        Integer id = coffeeOrder.getId();

        /*
        Я знаю, что есть метод isExistById, но я нашел на StackOverFlow сравнение
        isExistById и findById. На удивление производительность выше у второго.
         */
        if (id != null && repository.findById(id).isPresent())
            throw new CoffeeException("Заказ с таким id уже существует.");

        /*
        Получаю ту сущность кофе, что реально находится в базе данных.
         */
        Coffee coffee = coffeeService.getCoffee(coffeeOrder.getCoffee().getId());

        Integer idCoffeeMachine = coffeeOrder.getCoffeeMachine().getId();

        /*
        Данным вызовом мы обновляем запасы кофемашины и уменьшаем счетчик доступных операций
        по приготовлению кофе.
         */
        CoffeeMachine coffeeMachine = coffeeMachineService.cookCoffee(idCoffeeMachine, coffee);

        /*
        Я хотел ограничить возможность обновления сущностей кофе и кофемашины
        через добавления записи об их использовании, поэтому по сути из получаемого
        по сети пакета я беру только их id.
        У Вас может появиться два вопроса:
        1) почему тогда просто эти поля не сделать примитивами?
        Ответ: примитивы мне не подходят, потому что я хочу отправлять документ с данными о кофе и
        о текущем остатке кофемашины. DTO я создавать не хочу ради пары полей.
        2) Почему не сделать join-table в сущности coffee или coffee_machine
        Ответ: я хочу показывать время приготовления каждой конкретной чашки кофе.

         */
        coffeeOrder.setCoffee(coffee);
        coffeeOrder.setCoffeeMachine(coffeeMachine);

        return repository.save(coffeeOrder);
    }
}
