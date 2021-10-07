package com.example.demo.service.impl;

import com.example.demo.entity.OrderService;
import com.example.demo.repository.OrderServiceRepository;
import com.example.demo.service.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceServiceImpl implements OrderServiceService {
    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Override
    public void save(OrderService orderService) {
        orderServiceRepository.save(orderService);
    }
}
