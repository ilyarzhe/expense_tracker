package com.example.expensetracker.services;

import com.example.expensetracker.models.Expense;
import com.example.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    public Optional<Expense> findExpenseById(Long id){
        return expenseRepository.findById(id);
    }
    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
    public List<Expense> findAllExpenses(){
        return expenseRepository.findAll();
    }



}
