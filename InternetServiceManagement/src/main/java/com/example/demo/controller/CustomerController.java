package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/info/{id}")
    public ResponseEntity<Customer> customerInfo(@PathVariable String id){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Customer> update(@Validated @RequestBody CustomerDTO customerDTO, @PathVariable String id, BindingResult bindingResult) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (!bindingResult.hasErrors() && id != null) {
            if (customerService.findById(id) != null) {
                customerService.updateCustomer(customerDTO, id);
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
