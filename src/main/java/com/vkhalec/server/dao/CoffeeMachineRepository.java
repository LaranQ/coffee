package com.vkhalec.server.dao;

import com.vkhalec.shared.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Integer> {
}
