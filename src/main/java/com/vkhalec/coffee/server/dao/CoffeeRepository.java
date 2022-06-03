package com.vkhalec.coffee.server.dao;

import com.vkhalec.coffee.shared.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}
