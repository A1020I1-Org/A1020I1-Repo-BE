package com.example.demo.service;

import com.example.demo.entity.OrderService;
import com.example.demo.entity.OrderServiceDTO;

public interface OrderServiceService {
    void save(OrderService orderService);

    OrderService findById(Integer id);

    void createOrderService(OrderServiceDTO orderServiceDTO);
}
