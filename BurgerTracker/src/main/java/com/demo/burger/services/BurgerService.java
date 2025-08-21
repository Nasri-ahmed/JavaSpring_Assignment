package com.demo.burger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.burger.models.Burger;
import com.demo.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    // READ ALL
    public List<Burger> allBurgers() {
        return (List<Burger>) burgerRepository.findAll();
    }

    // CREATE
    public Burger createBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    // READ ONE
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        return optionalBurger.orElse(null);
    }

    // UPDATE
    public Burger updateBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    // DELETE 
    public void deleteBurger(Long id) {
        burgerRepository.deleteById(id);
    }
}
