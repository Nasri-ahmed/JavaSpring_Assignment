package com.demo.burger.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.burger.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	
}