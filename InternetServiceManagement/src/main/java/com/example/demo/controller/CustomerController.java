package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer blog){
        customerService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = {"/info/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> customerInfo(@PathVariable String id, Model model){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable String id) {
        if (this.customerService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
