package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.http.request.CustomerRequest;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id){
        if (customerService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.createCustomer(customerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerRequest customerRequest,
                                                   @PathVariable Integer id){
        if (customerService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            customerService.updateCustomer(customerRequest, id);
            return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
        }
    }
}
