package com.example.demo.service;

import com.example.demo.entity.Customer;

public interface CustomerService {
    void save(Customer customer);

    boolean checkEmail(String email);
}
