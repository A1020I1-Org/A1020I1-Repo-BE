package com.example.demo.service.impl;
import com.example.demo.entity.Pay;
import com.example.demo.repository.PayRepository;
import com.example.demo.service.PayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayRepository payRepository;

    @Override
    public Pay findById(Integer id) {
        return payRepository.findById(id).orElse(null);
    }

}
