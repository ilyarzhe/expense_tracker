package com.example.expensetracker.controllers;

import com.example.expensetracker.models.Merchant;
import com.example.expensetracker.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping
    public ResponseEntity<List<Merchant>> findAllMerchants(){
        return ResponseEntity.ok(merchantService.getAllMerchants());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Merchant> findMerchantById(@PathVariable Long id){
        return merchantService.getMerchantById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant){
        return ResponseEntity.status(HttpStatus.CREATED).body(merchant);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Merchant> updateMerchant(@PathVariable Long id, @RequestBody Merchant merchant){
        merchant.setId(id);
        return ResponseEntity.ok(merchantService.saveMerchant(merchant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.noContent().build();
    }

}
