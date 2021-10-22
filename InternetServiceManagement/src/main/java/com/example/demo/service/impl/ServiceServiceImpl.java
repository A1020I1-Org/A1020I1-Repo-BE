package com.example.demo.service.impl;

import com.example.demo.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Override
    public List<com.example.demo.entity.Service> findAll() {
        return null;
    }

    @Override
    public com.example.demo.entity.Service findById(String id) {
        return null;
    }

    @Override
    public void save(com.example.demo.entity.Service service) {

    }

    @Override
    public void delete(com.example.demo.entity.Service service) {

    }
}
