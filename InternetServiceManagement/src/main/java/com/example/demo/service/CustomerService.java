package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    //    List<Customer> getListCustomer();
    Page<Customer> getAllCustomer(Pageable pageable);

    Page<Customer> searchCustomer(Pageable pageable, String username, String status,
                                  String address, String dateBirthFrom, String dateBirthTo);




    void deleteCustomer(Integer customerId);

    Customer getCustomerByUsername(String username);

    Optional<Customer> findById(Integer id);
}