package com.example.demo.repository;

import com.example.demo.entity.OrderHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHourRepository extends JpaRepository<OrderHour,Integer> {
}
