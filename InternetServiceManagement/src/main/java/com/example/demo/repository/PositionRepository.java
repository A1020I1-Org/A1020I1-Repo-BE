package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PositionRepository extends JpaRepository<Position, Integer> {
}
