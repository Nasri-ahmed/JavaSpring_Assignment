package com.demo.burger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.burger.models.Burger;
import com.demo.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public List<Burger> allBurgers() {
        return (List<Burger>) burgerRepository.findAll();
    }

    public Burger createBurger(Burger burger) {
        return burgerRepository.save(burger);
    }
}