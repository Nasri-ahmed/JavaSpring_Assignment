package com.demo.ninja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.demo.ninja.models.Dojo;
import com.demo.ninja.services.DojoService;

@Controller
public class DojoController {

    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    // صفحة إنشاء Dojo
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo";
    }

    // حفظ Dojo جديد
    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if(result.hasErrors()) {
            return "newDojo";
        }
        dojoService.create(dojo);
        return "redirect:/dojos";
    }

    // عرض صفحة Dojo واحدة
    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findById(id);
        model.addAttribute("dojo", dojo);
        return "showDojo";
    }

    // عرض جميع الدوجوز
    @GetMapping("/dojos")
    public String allDojos(Model model) {
        model.addAttribute("dojos", dojoService.findAll());
        return "index"; // صفحة تعرض كل الدوجوز
    }
}
