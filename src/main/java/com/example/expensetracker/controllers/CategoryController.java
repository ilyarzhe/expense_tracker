package com.example.expensetracker.controllers;

import com.example.expensetracker.models.Category;
import com.example.expensetracker.models.Expense;
import com.example.expensetracker.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
        return categoryService.findCategoryById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        category.setId(id);
        return ResponseEntity.ok(categoryService.saveCategory(category));

    }
}
