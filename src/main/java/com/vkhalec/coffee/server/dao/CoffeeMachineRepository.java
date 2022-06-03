package com.vkhalec.coffee.server.dao;

import com.vkhalec.coffee.shared.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Integer> {
}
