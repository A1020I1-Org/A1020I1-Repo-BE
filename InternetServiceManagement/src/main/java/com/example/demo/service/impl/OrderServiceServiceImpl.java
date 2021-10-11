package com.example.demo.service.impl;

import com.example.demo.entity.OrderService;
import com.example.demo.repository.OrderServiceRepository;
import com.example.demo.service.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceServiceImpl implements OrderServiceService {
    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Override
    public void save(OrderService orderService) {
        orderServiceRepository.save(orderService);
    }

    @Override
    public OrderService findById(Integer id) {
        return orderServiceRepository.findById(id).orElse(null);
    }
}
