package com.demo.ninja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.demo.ninja.models.Ninja;
import com.demo.ninja.services.DojoService;
import com.demo.ninja.services.NinjaService;

@Controller
public class NinjaController {

    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    // صفحة إنشاء Ninja
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoService.findAll());
        return "newNinja";
    }

    // حفظ Ninja جديد
    @PostMapping("/ninjas")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("dojos", dojoService.findAll());
            return "newNinja";
        }
        // ربط Ninja بالـ Dojo الصحيح
        Long dojoId = ninja.getDojo().getId();
        ninja.setDojo(dojoService.findById(dojoId));

        ninjaService.create(ninja);
        return "redirect:/dojos/" + dojoId;
    }
}
