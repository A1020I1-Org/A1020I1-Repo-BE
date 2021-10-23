package com.example.demo.service.impl;

import com.example.demo.entity.Computer;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public Computer findById(int id) {
        return computerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void update(Computer computer, int id) {
        computerRepository.save(computer);
    }

}
