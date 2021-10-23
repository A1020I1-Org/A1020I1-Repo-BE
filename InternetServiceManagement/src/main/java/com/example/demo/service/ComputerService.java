package com.example.demo.service;

import com.example.demo.entity.Computer;

public interface ComputerService {
    Computer findByIpHost(String ip);
}
