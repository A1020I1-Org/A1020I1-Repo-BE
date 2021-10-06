package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.AccountRoleService;
import com.example.demo.service.AccountService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    AccountRoleService accountRoleService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody AccountCustomer accountCustomer){
        Account account = new Account(accountCustomer.getUserName(), accountCustomer.getPassword());
        accountService.save(account);
        AccountRoleKey accountRoleKey = new AccountRoleKey(account.getUserName(),1);
        Role role = roleService.findById(1);
        AccountRole accountRole = new AccountRole(accountRoleKey,account,role);
        accountRoleService.save(accountRole);

        Customer customer = new Customer(accountCustomer.getCustomerId(),accountCustomer.getFullName(),accountCustomer.getDateOfBirth(),
                accountCustomer.getEmail(),accountCustomer.getAddress(),accountCustomer.getPhone(),accountCustomer.isStatus(),accountCustomer.getIdCard(),account);
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
