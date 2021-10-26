package com.example.demo.controller;

import com.example.demo.entity.CustomerRequest;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")
    public CustomerRequest getCustomer(@PathVariable Integer id){
       return customerService.findById(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CustomerRequest> createCustomer(@Validated @RequestBody CustomerRequest customerRequest, BindingResult bindingResult){
        new CustomerRequest().validate(customerRequest, bindingResult);
        if (!bindingResult.hasErrors()) {
            customerService.createCustomer(customerRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<CustomerRequest> updateCustomer(@Validated @RequestBody CustomerRequest customerRequest,
                                                          BindingResult bindingResult,
                                                          @PathVariable Integer id){
        new CustomerRequest().validate(customerRequest, bindingResult);
        if (!bindingResult.hasErrors() && id != null) {
            if (customerService.findById(id) != null) {
                customerService.updateCustomer(customerRequest, id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/info/{id}")
    public ResponseEntity<CustomerRequest> infoCustomer(@Validated @RequestBody CustomerRequest customerRequest,
                                                        BindingResult bindingResult,
                                                        @PathVariable Integer id){
        new CustomerRequest().validate(customerRequest, bindingResult);
        if (!bindingResult.hasErrors() && id != null) {
            if (customerService.findById(id) != null) {
                customerService.updateCustomer(customerRequest, id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
