package com.vkhalec.coffee.server.dao;

import com.vkhalec.coffee.shared.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Integer> {

    @Override
//    @EntityGraph(attributePaths = {"coffee, coffeeMachine"})
    List<CoffeeOrder> findAll();
}
