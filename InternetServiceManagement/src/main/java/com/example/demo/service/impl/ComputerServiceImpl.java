package com.example.demo.service.impl;

import com.example.demo.entity.Computer;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    ComputerRepository computerRepository;
    @Override
    public Computer findByIpHost(String ip) {
        return computerRepository.findByComputerIpLocal(ip);
    }
}
