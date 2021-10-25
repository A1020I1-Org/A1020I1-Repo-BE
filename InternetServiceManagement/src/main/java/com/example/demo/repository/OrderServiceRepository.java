package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderServiceRepository extends JpaRepository<OrderService, Integer> {

}
