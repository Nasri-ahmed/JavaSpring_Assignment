package com.projects.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	
	@GetMapping("/omikuji")
    public String omikujiForm() {
        return "omikuji"; 
    }
	
	
	@PostMapping("/omikuji/process")
	public String processForm(
	        @RequestParam("number") int number,
	        @RequestParam("city") String city,
	        @RequestParam("name") String name,
	        @RequestParam("profession") String profession,
	        @RequestParam("thing") String thing,
	        @RequestParam("niceMessage") String niceMessage,
	        HttpSession session
	) {
	    session.setAttribute("number", number);
	    session.setAttribute("city", city);
	    session.setAttribute("name", name);
	    session.setAttribute("profession", profession);
	    session.setAttribute("thing", thing);
	    session.setAttribute("niceMessage", niceMessage);

	    return "redirect:/omikuji/show";
	}

	@GetMapping("/omikuji/show")
	public String showFortune(HttpSession session, Model model) {
	    model.addAttribute("number", session.getAttribute("number"));
	    model.addAttribute("city", session.getAttribute("city"));
	    model.addAttribute("name", session.getAttribute("name"));
	    model.addAttribute("profession", session.getAttribute("profession"));
	    model.addAttribute("thing", session.getAttribute("thing"));
	    model.addAttribute("niceMessage", session.getAttribute("niceMessage"));

	    return "show"; 
	}


}
