package com.example.demo.service;

import com.example.demo.entity.AccountCustomer;

public interface CustomerService {
    void createCustomer(AccountCustomer accountCustomer);

    void updateCustomer(AccountCustomer accountCustomer, Integer id);
    
    AccountCustomer findById(Integer id);
}
