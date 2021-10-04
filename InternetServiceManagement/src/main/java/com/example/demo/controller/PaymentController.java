package com.example.demo.controller;

import com.example.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pay")
public class PaymentController {
    @Autowired
    private PayService payService;


}
