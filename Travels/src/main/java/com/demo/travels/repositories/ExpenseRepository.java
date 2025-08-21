package com.demo.travels.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.travels.models.Expense;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	
}