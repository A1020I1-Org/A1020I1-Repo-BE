package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.http.request.CustomerRequest;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Autowired
    private CustomerServiceImpl(CustomerRepository customerRepository,
                                AccountRepository accountRepository){
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        if (customerRequest.getPassword().equals(customerRequest.getPasswordRetype())){
            Customer customer = new Customer();
            Account account = new Account();
            customer.setFullName(customerRequest.getFullName());
            customer.setAddress(customerRequest.getAddress());
            customer.setDateOfBirth(customerRequest.getDateOfBirth());
            customer.setEmail(customerRequest.getEmail());
            customer.setPhone(customerRequest.getPhone());
            customer.setStatus(customerRequest.getStatus());
            account.setUserName(customerRequest.getUsername());
            account.setPassword(customerRequest.getPassword());
            customer.setAccount(account);
            account.setCustomer(customer);
            customerRepository.save(customer);
            accountRepository.save(account);
        }
    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        Account account = accountRepository.findByUserName(customerRequest.getUsername()).orElse(null);
        if (customer != null && account != null) {
            if (customerRequest.getPassword().equals(customerRequest.getPasswordRetype())) {
                customer.setFullName(customerRequest.getFullName());
                customer.setAddress(customerRequest.getAddress());
                customer.setDateOfBirth(customerRequest.getDateOfBirth());
                customer.setEmail(customerRequest.getEmail());
                customer.setPhone(customerRequest.getPhone());
                customer.setStatus(customerRequest.getStatus());
                account.setPassword(customerRequest.getPassword());
                customer.setAccount(account);
                account.setCustomer(customer);
                customerRepository.save(customer);
                accountRepository.save(account);
            }
        }
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
}
