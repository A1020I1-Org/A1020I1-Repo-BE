package com.example.demo.controller;

import com.example.demo.entity.AccountCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.entity.*;
import com.example.demo.service.AccountRoleService;
import com.example.demo.service.AccountService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    AccountRoleService accountRoleService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/checkUser/{userName}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getAllAccount(@PathVariable("userName") String userName){
        return new ResponseEntity<>(accountService.checkUserName(userName), HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<List<FieldError>> create(@RequestBody @Valid AccountCustomer accountCustomer, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        if (accountService.checkUserName(accountCustomer.getUserName())){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(accountCustomer.getPassword());
        Account account = new Account(accountCustomer.getUserName(), pass);
        accountService.save(account);
        AccountRoleKey accountRoleKey = new AccountRoleKey(accountCustomer.getUserName(),1);
        Role role = roleService.findById(1);
        AccountRole accountRole = new AccountRole(accountRoleKey,account,role);
        accountRoleService.save(accountRole);

        Customer customer = new Customer(accountCustomer.getCustomerId(),accountCustomer.getFullName(),accountCustomer.getDateOfBirth(),
                accountCustomer.getEmail(),accountCustomer.getAddress(),accountCustomer.getPhone(),accountCustomer.isStatus(),accountCustomer.getIdCard(),account);
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
