package com.example.demo.service;

import com.example.demo.entity.OrderService;
import com.example.demo.entity.OrderServiceDTO;

public interface OrderServiceService {
    OrderService findById(String id);

    void createOrderService(OrderServiceDTO orderServiceDTO);
}
