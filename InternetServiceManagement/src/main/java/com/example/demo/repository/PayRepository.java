package com.example.demo.repository;

import com.example.demo.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay,Integer> {
}
