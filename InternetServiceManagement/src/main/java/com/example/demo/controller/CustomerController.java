package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping(value = {"/info/{id}"})
    public ResponseEntity<Customer> customerInfo(@PathVariable String id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("blogInfo", customer);
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
