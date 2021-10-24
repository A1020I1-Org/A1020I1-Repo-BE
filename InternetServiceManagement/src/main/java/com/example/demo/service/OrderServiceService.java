package com.example.demo.service;

import com.example.demo.entity.OrderService;
import com.example.demo.entity.OrderServiceDTO;
import com.example.demo.entity.Service;

public interface OrderServiceService {
    OrderService findById(Integer id);

    void createOrderService(OrderServiceDTO orderServiceDTO, String serviceId);

}
