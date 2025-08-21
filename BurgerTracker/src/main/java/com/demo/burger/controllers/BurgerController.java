package com.demo.burger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.burger.models.Burger;
import com.demo.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    // READ ALL + CREATE FORM
    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger, Model model) {
        model.addAttribute("burgers", burgerService.allBurgers());
        return "index";
    }

    // CREATE
    @PostMapping("/burgers")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("burgers", burgerService.allBurgers());
            return "index"; // show errors
        }
        burgerService.createBurger(burger);
        return "redirect:/"; // redirect to GET / to refresh table and clear form
    }

    // EDIT FORM
    @GetMapping("/burgers/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.findBurger(id);
        if (burger == null) {
            return "redirect:/"; // redirect if not found
        }
        model.addAttribute("burger", burger);
        return "edit";
    }

    // UPDATE
    @PostMapping("/burgers/update/{id}")
    public String update(@Valid @ModelAttribute("burger") Burger burger,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            return "edit";
        }
        burgerService.updateBurger(burger);
        return "redirect:/";
    }
}
