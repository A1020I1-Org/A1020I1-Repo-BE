package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    void saveCustomer(Customer customer);

    void deletedCustomer(Integer id);
}
