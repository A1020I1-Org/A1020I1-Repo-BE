package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.AccountCustomer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void updateCustomer(AccountCustomer customerAccount, String id) {
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

    private AccountCustomer toDTO(Customer customer){
        AccountCustomer accountCustomer = new AccountCustomer();
        accountCustomer.setCustomerId(customer.getCustomerId());
        accountCustomer.setFullName(customer.getFullName());
        accountCustomer.setDateOfBirth(customer.getDateOfBirth());
        accountCustomer.setEmail(customer.getEmail());
        String[] address = customer.getAddress().split(",");
        accountCustomer.setProvince(address[0]);
        accountCustomer.setDistrict(address[1]);
        accountCustomer.setCommune(address[2]);
        accountCustomer.setPhone(customer.getPhone());
        accountCustomer.setUsername(customer.getAccount().getUserName());
        accountCustomer.setPassword(customer.getAccount().getPassword());
        accountCustomer.setPasswordRetype(customer.getAccount().getPassword());
        accountCustomer.setStatus(customer.getStatus());
        return accountCustomer;
    }

    private Customer toEntity(AccountCustomer accountCustomer){
        Customer customer = new Customer();
        if (accountCustomer.getCustomerId() != null) {
            Optional<Customer> test = customerRepository.findById(accountCustomer.getCustomerId());
            if (test.isPresent()) {
                customer = test.get();
            }
        }
        customer.setFullName(accountCustomer.getFullName());
        customer.setDateOfBirth(accountCustomer.getDateOfBirth());
        customer.setEmail(accountCustomer.getEmail());
        customer.setAddress(accountCustomer.getProvince()
                + "," + accountCustomer.getDistrict() + "," + accountCustomer.getCommune());
        customer.setPhone(accountCustomer.getPhone());
        customer.setStatus(accountCustomer.getStatus());
//        Account account = new Account();
//        if (!accountRepository.findByUserName(customerRequest.getUsername()).isPresent()){
//            account.setUserName(customerRequest.getUsername());
//            account.setPassword(customerRequest.getPassword());
//            customer.setAccount(account);
//        }
        return customer;
    }

}
