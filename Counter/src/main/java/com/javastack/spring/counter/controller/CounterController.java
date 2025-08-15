package com.javastack.spring.counter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	
	@GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0); 
        } else {
            int currentCount = (int) session.getAttribute("count");
            session.setAttribute("count", currentCount + 1);
        }
        return "index.jsp";
    }

    @GetMapping("/counter")
    public String counter(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0); 
        }
        return "counter.jsp"; 
    }

    
    @GetMapping("/double")
    public String doubleIncrement(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            int currentCount = (int) session.getAttribute("count");
            session.setAttribute("count", currentCount + 2);
        }
        return "index.jsp";
    }

    @GetMapping("/reset")
    public String reset(HttpSession session) {
        session.setAttribute("count", 0);
        return "counter.jsp";
    }
	

}
