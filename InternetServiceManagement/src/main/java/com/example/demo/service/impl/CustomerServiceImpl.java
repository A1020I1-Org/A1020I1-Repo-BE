package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerDTO;
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
    public void updateCustomer(CustomerDTO customerAccount, String id) {
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

    private CustomerDTO toDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setFullName(customer.getFullName());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        customerDTO.setEmail(customer.getEmail());
        String[] address = customer.getAddress().split(",");
        customerDTO.setProvince(address[0]);
        customerDTO.setDistrict(address[1]);
        customerDTO.setCommune(address[2]);
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setUsername(customer.getAccount().getUserName());
        customerDTO.setPassword(customer.getAccount().getPassword());
        customerDTO.setPasswordRetype(customer.getAccount().getPassword());
        customerDTO.setStatus(customer.getStatus());
        return customerDTO;
    }

    private Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        if (customerDTO.getCustomerId() != null) {
            Optional<Customer> test = customerRepository.findById(customerDTO.getCustomerId());
            if (test.isPresent()) {
                customer = test.get();
            }
        }
        customer.setFullName(customerDTO.getFullName());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getProvince()
                + "," + customerDTO.getDistrict() + "," + customerDTO.getCommune());
        customer.setPhone(customerDTO.getPhone());
        customer.setStatus(customerDTO.getStatus());
//        Account account = new Account();
//        if (!accountRepository.findByUserName(customerRequest.getUsername()).isPresent()){
//            account.setUserName(customerRequest.getUsername());
//            account.setPassword(customerRequest.getPassword());
//            customer.setAccount(account);
//        }
        return customer;
    }

}
