package com.example.demo.service.impl;

import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.example.demo.entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public com.example.demo.entity.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.example.demo.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(com.example.demo.entity.Service service) {
        serviceRepository.delete(service);
    }
}
