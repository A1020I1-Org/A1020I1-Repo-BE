package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(String customerId);

    void save(Customer customer);

    List<Customer> findAll();
}
