package com.example.demo.repository;

import com.example.demo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusComputerRepository extends JpaRepository<Status,Integer> {
}
