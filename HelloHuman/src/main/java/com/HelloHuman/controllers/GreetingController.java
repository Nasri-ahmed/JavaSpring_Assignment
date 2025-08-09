package com.HelloHuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@GetMapping("/")
    public String greet(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "last_name", required = false) String lastName,
            @RequestParam(value = "times", required = false, defaultValue = "1") int times) {

     
        if (name == null || name.isEmpty()) {
            name = "human";
        }

        String fullName = (lastName == null || lastName.isEmpty()) ? name : name + " " + lastName;

        StringBuilder greetingBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            greetingBuilder.append("Hello ").append(fullName);
            if (i < times - 1) {
                greetingBuilder.append(" ");
            }
        }

        return greetingBuilder.toString();
    }

}
