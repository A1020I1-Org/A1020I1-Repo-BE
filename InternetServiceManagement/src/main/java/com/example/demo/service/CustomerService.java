package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.http.request.CustomerRequest;

public interface CustomerService {
    void save(Customer customer);

    boolean checkEmail(String email);

    void createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest, Integer id);
    
    CustomerRequest findById(Integer id);
}
