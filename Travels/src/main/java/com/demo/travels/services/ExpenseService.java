package com.demo.travels.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.demo.travels.models.Expense;
import com.demo.travels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // READ ALL
    public List<Expense> allExpenses() {
        return (List<Expense>) expenseRepository.findAll();
    }

    // CREATE
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // READ ONE
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    // UPDATE
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // DELETE
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}