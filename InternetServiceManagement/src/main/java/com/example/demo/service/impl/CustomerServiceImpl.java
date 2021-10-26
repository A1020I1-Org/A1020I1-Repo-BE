package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerRequest;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            Customer customer = toEntity(customerRequest);
            Account account = new Account();
            account.setUserName(customerRequest.getUsername());
            account.setPassword(customerRequest.getPassword());
            account.setCustomer(customer);

            customer.setAccount(account);

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
                customer = toEntity(customerRequest);
                customer.setCustomerId(id);
                account.setPassword(customerRequest.getPassword());
                customer.setAccount(account);
                account.setCustomer(customer);
                customerRepository.save(customer);
                accountRepository.save(account);
            }
        }
    }

    @Override
    public CustomerRequest findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null){
            return toRequest(customer);
        }
        else {
            return null;
        }
    }

    private CustomerRequest toRequest(Customer customer){
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerId(customer.getCustomerId());
        customerRequest.setFullName(customer.getFullName());
        customerRequest.setDateOfBirth(customer.getDateOfBirth());
        customerRequest.setEmail(customer.getEmail());
        String[] address = customer.getAddress().split(",");
        customerRequest.setProvince(address[0]);
        customerRequest.setDistrict(address[1]);
        customerRequest.setCommune(address[2]);
        customerRequest.setPhone(customer.getPhone());
        customerRequest.setUsername(customer.getAccount().getUserName());
        customerRequest.setPassword(customer.getAccount().getPassword());
        customerRequest.setPasswordRetype(customer.getAccount().getPassword());
        customerRequest.setStatus(customer.getStatus());
        return customerRequest;
    }

    private Customer toEntity(CustomerRequest customerRequest){
        Customer customer = new Customer();
        if (customerRequest.getCustomerId() != null) {
            Optional<Customer> test = customerRepository.findById(customerRequest.getCustomerId());
            if (test.isPresent()) {
                customer = test.get();
            }
        }
        customer.setFullName(customerRequest.getFullName());
        customer.setDateOfBirth(customerRequest.getDateOfBirth());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getProvince()
                + "," + customerRequest.getDistrict() + "," + customerRequest.getCommune());
        customer.setPhone(customerRequest.getPhone());
        customer.setStatus(customerRequest.getStatus());
        return customer;
    }
}
