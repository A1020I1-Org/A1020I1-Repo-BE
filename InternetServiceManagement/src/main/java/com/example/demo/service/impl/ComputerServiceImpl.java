package com.example.demo.service.impl;

import com.example.demo.entity.Computer;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    ComputerRepository computerRepository;
    @Override
    public List<Computer> finAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computer findById(String id) {
        return computerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        computerRepository.deleteById(id);
    }
}
