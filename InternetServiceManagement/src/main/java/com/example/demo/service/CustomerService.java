package com.example.demo.service;

import com.example.demo.entity.CustomerRequest;

public interface CustomerService {
    void createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest, Integer id);
    
    CustomerRequest findById(Integer id);
}
