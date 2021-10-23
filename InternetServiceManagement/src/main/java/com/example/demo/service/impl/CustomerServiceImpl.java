package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;
    /*
    @Override
    public  List<Customer> getListCustomer() {
        return customerRepository.getListCustomer();
    }
    */

//    @Override
//    public List<Customer> getListCustomer() {
//        return customerRepository.findAll();
//    }


    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return customerRepository.getListCustomer(pageable);
    }

    @Override
    public Page<Customer> searchCustomer( Pageable pageable, String username, String status, String address, String dateBirthFrom, String dateBirthTo) {
        return customerRepository.searchCustomer(pageable, username, dateBirthFrom, dateBirthTo, status, address);
    }


    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return  customerRepository.getCustomerByUsername(username);
    }

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return customerService.findById(customerId);
    }
}

