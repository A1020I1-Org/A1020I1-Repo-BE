package com.example.demo.controller;

import com.example.demo.entity.Pay;
import com.example.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/pay")
public class PaymentController {
    @Autowired
    private PayService payService;

    //-------------------Retrieve All Payment--------------------------------------------------------
    @RequestMapping(value = "/payList/", method = RequestMethod.GET)
    public ResponseEntity<List<Pay>> listAllPayment() {
        List<Pay> pays = payService.findALl();
        if (pays.isEmpty()) {
            return new ResponseEntity<List<Pay>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pay>>(pays, HttpStatus.OK);
    }

    //-------------------Retrieve Single Payment--------------------------------------------------------
    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pay> getPay(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        Pay pay = payService.findById(id);
        if (pay == null) {
            System.out.println("Pay with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pay, HttpStatus.OK);
    }

    //-------------------Create a Payment--------------------------------------------------------
    @RequestMapping(value = "/payment/", method = RequestMethod.POST)
    public ResponseEntity<Pay> createPayment(@RequestBody Pay pay) {
        System.out.println("Creating Payment " + pay.getCustomer().getEmail());
        payService.save(pay);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //------------------- Update a Payment --------------------------------------------------------
    @RequestMapping(value = "/payment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pay> updateCustomer(@PathVariable("id") int id, @RequestBody Pay pay) {
        System.out.println("Updating Customer " + id);

        Pay currentPay = payService.findById(id);

        if (currentPay == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentPay.setStatus(pay.isStatus());
        currentPay.setTotalPayment(pay.getTotalPayment());
        currentPay.setPayId(pay.getPayId());
        payService.save(currentPay);
        return new ResponseEntity<>(currentPay, HttpStatus.OK);
    }

}
