package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/customer/list")
    public ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.getAllCustomer(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String deleteCustomer(@RequestParam("id") Integer customerId, Model model) {
//        customerService.deletedCustomer(customerId);
//        return "redirect:/list";
//    }

    @DeleteMapping("/customer/delete/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        this.customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("customer/search")
    public ResponseEntity<Page<Customer>> getSearchCustomer(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String username,
                                                            @RequestParam(defaultValue = "1900-01-01") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "2100-01-01") String dateBirthTo,
                                                            @RequestParam(defaultValue = "")String status,
                                                            @RequestParam(defaultValue = "")String address ) {
        Page<Customer> customers = customerService.searchCustomer(pageable,username,status,address,dateBirthFrom,dateBirthTo);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
