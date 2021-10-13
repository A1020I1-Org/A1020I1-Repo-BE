package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerAccount;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Customer findById(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(CustomerAccount customerAccount, String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        Account account = accountRepository.findByUserName(customerAccount.getUsername()).orElse(null);
        if (customer != null && account != null) {
            if (customerAccount.getPassword().equals(customerAccount.getPasswordRetype())) {
                customer = toEntity(customerAccount);
                customer.setCustomerId(id);
                account.setPassword(customerAccount.getPassword());
                customer.setAccount(account);
                account.setCustomer(customer);
                customerRepository.save(customer);
                accountRepository.save(account);
            }
        }
    }

    private CustomerAccount toRequest(Customer customer){
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCustomerId(customer.getCustomerId());
        customerAccount.setFullName(customer.getFullName());
        customerAccount.setDateOfBirth(customer.getDateOfBirth());
        customerAccount.setEmail(customer.getEmail());
        String[] address = customer.getAddress().split(",");
        customerAccount.setProvince(address[0]);
        customerAccount.setDistrict(address[1]);
        customerAccount.setCommune(address[2]);
        customerAccount.setPhone(customer.getPhone());
        customerAccount.setUsername(customer.getAccount().getUserName());
        customerAccount.setPassword(customer.getAccount().getPassword());
        customerAccount.setPasswordRetype(customer.getAccount().getPassword());
        customerAccount.setStatus(customer.getStatus());
        return customerAccount;
    }

    private Customer toEntity(CustomerAccount customerAccount){
        Customer customer = new Customer();
        if (customerAccount.getCustomerId() != null) {
            if (customerRepository.findById(customerAccount.getCustomerId()).isPresent()) {
                customer = customerRepository.findById(customerAccount.getCustomerId()).get();
            }
        }
        customer.setFullName(customerAccount.getFullName());
        customer.setDateOfBirth(customerAccount.getDateOfBirth());
        customer.setEmail(customerAccount.getEmail());
        customer.setAddress(customerAccount.getProvince()
                + "," + customerAccount.getDistrict() + "," + customerAccount.getCommune());
        customer.setPhone(customerAccount.getPhone());
        customer.setStatus(customerAccount.getStatus());
//        Account account = new Account();
//        if (!accountRepository.findByUserName(customerRequest.getUsername()).isPresent()){
//            account.setUserName(customerRequest.getUsername());
//            account.setPassword(customerRequest.getPassword());
//            customer.setAccount(account);
//        }
        return customer;
    }

}
