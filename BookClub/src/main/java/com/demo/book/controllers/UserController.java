package com.demo.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.book.models.LoginUser;
import com.demo.book.models.User;
import com.demo.book.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){ this.userService = userService; }

    @GetMapping("/")
    public String index(Model model, HttpSession session){
        if(session.getAttribute("userId") != null) return "redirect:/books";
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @PostMapping("/register")
    public String register(@Valid User newUser, BindingResult result,
                           Model model, HttpSession session){
        User user = userService.register(newUser, result);
        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/books";
    }

    @PostMapping("/login")
    public String login(@Valid LoginUser newLogin, BindingResult result,
                        Model model, HttpSession session){
        User user = userService.login(newLogin, result);
        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "index";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
