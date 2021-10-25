package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.AccountCustomer;
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
    public void createCustomer(AccountCustomer accountCustomer) {
        if (accountCustomer.getPassword().equals(accountCustomer.getPasswordRetype())){
            Customer customer = toEntity(accountCustomer);
            Account account = new Account();
            account.setUserName(accountCustomer.getUsername());
            account.setPassword(accountCustomer.getPassword());
            account.setCustomer(customer);

            customer.setAccount(account);

            customerRepository.save(customer);
            accountRepository.save(account);
        }
    }

    @Override
    public void updateCustomer(AccountCustomer accountCustomer, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        Account account = accountRepository.findByUserName(accountCustomer.getUsername()).orElse(null);
        if (customer != null && account != null) {
            if (accountCustomer.getPassword().equals(accountCustomer.getPasswordRetype())) {
                customer = toEntity(accountCustomer);
                customer.setCustomerId(id);
                account.setPassword(accountCustomer.getPassword());
                customer.setAccount(account);
                account.setCustomer(customer);
                customerRepository.save(customer);
                accountRepository.save(account);
            }
        }
    }

    @Override
    public AccountCustomer findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null){
            return toRequest(customer);
        }
        else {
            return null;
        }
    }

    private AccountCustomer toRequest(Customer customer){
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
        return customer;
    }
}
