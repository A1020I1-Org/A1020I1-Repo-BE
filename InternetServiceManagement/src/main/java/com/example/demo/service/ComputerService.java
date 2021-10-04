package com.example.demo.service;

import com.example.demo.entity.Computer;

import java.util.List;

public interface ComputerService {
    List<Computer> finAll();
    Computer findById(String id);
    void delete (String id);
}
