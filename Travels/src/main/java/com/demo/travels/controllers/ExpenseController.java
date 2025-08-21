package com.demo.travels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.travels.models.Expense;
import com.demo.travels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // INDEX + CREATE FORM
    @GetMapping("/")
    public String index(@ModelAttribute("expense") Expense expense, Model model) {
        model.addAttribute("expenses", expenseService.allExpenses());
        return "index";
    }

    // CREATE
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense,
                         BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("expenses", expenseService.allExpenses());
            return "index";
        }
        expenseService.createExpense(expense);
        return "redirect:/";
    }

    // SHOW
    @GetMapping("/expenses/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "show";
    }

    // EDIT FORM
    @GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit";
    }

    // UPDATE
    @PostMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense,
                         BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "edit";
        }
        expenseService.updateExpense(expense);
        return "redirect:/";
    }

    // DELETE
    @PostMapping("/expenses/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }
}