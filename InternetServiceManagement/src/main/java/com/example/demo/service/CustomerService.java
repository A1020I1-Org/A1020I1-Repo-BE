package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.http.request.CustomerRequest;

public interface CustomerService {
    void createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest, Integer id);
    
    CustomerRequest findById(Integer id);
import com.example.demo.entity.CustomerDTO;

import java.util.List;

public interface CustomerService {
    Customer findById(String customerId);

    void save(Customer customer);

    List<Customer> findAll();

    void updateCustomer(CustomerDTO customerAccount, String id);

}
