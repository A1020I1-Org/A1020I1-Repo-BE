package com.example.demo.repository;

import com.example.demo.entity.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<OrderService, Integer> {
}
