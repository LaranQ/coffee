package com.vkhalec.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.vkhalec.client.CoffeeService;
import com.vkhalec.server.dao.CoffeeRepository;
import com.vkhalec.shared.Coffee;
import com.vkhalec.server.exception_handling.CoffeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeServiceImpl extends RemoteServiceServlet
        implements CoffeeService {

    @Autowired
    private CoffeeRepository repository;

    @Override
    public List<Coffee> getAllCoffee() {
        return repository.findAll();
    }

    @Override
    public Coffee getCoffee(Integer id){
        Optional<Coffee> optional = repository.findById(id);

        if(optional.isPresent())
            return optional.get();

        throw new CoffeeException("Кофе с таким id не существует.");
    }
}