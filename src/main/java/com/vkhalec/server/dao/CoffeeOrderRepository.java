package com.vkhalec.server.dao;

import com.vkhalec.shared.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Integer> {

    @Override
//    @EntityGraph(attributePaths = {"coffee, coffeeMachine"})
    List<CoffeeOrder> findAll();
}
