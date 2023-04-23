package com.example.expensetracker.services;

import com.example.expensetracker.models.Merchant;
import com.example.expensetracker.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    public Optional<Merchant> getMerchantById(Long id){
        return merchantRepository.findById(id);
    }
    public List<Merchant> getAllMerchants(){
        return merchantRepository.findAll();
    }
    public Merchant saveMerchant(Merchant merchant){
        return  merchantRepository.save(merchant);
    }
    public void deleteMerchant(Long id){
        merchantRepository.deleteById(id);
    }
}
