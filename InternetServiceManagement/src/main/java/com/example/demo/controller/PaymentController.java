package com.example.demo.controller;

import com.example.demo.entity.Pay;
import com.example.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PayService payService;

    //-------------------Retrieve All Payment--------------------------------------------------------
    @RequestMapping(value = "/payList/", method = RequestMethod.GET)
    public ResponseEntity<Page<Pay>> listAllPayment(@PageableDefault(3) Pageable pageable) {
        Page<Pay> pays = payService.findAll(pageable);
        if (pays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(pays, HttpStatus.OK);
    }

    //-------------------Retrieve Search Payment--------------------------------------------------------
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Pay>> searchService(@RequestParam("searchName") String searchName,
                                                   @PageableDefault(3) Pageable pageable) {
        Page<Pay> searchPay = payService.search(pageable, searchName);
        if (searchPay == null){
            System.out.println("Not found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        payService.search(pageable,searchName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrieve Single Payment--------------------------------------------------------
    @RequestMapping(value = "/pay/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pay> getPay(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        Pay pay = payService.findById(id);
        if (pay == null) {
            System.out.println("Pay with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pay, HttpStatus.OK);
    }

    //-------------------Retrieve Pay Payment--------------------------------------------------------
    @RequestMapping(value = "/pay/{id}", method = RequestMethod.POST)
    public ResponseEntity<Pay> pay(@PathVariable("id") int id) {
        System.out.println(" Customer with id " + id);
        if (payService.pay(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
