package com.example.expensetracker.controllers;

import com.example.expensetracker.models.Expense;
import com.example.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return new ResponseEntity<List<Expense>>(expenseService.findAllExpenses(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Expense>> findExpenseById(@PathVariable Long id){
        return new ResponseEntity<Optional<Expense>>(expenseService.findExpenseById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense){
        expense.setId(id);
        return ResponseEntity.ok(expenseService.saveExpense(expense));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.saveExpense(expense));
    }
}
