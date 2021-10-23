package com.example.demo.repository;

import com.example.demo.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer,Integer> {
    Computer findByComputerIpLocal(String ipLocal);

}
