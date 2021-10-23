package com.example.demo.service;

import com.example.demo.entity.Computer;

public interface ComputerService {

    Computer findById(int id);

    void save(Computer computer);

    void update(Computer computer, int id);
}
