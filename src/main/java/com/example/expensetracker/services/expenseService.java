package com.example.expensetracker.services;

import com.example.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class expenseService {
    @Autowired
    private ExpenseRepository expenseRepository;


}
