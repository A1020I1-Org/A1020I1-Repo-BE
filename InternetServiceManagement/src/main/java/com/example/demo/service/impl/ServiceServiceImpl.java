package com.example.demo.service.impl;

import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @Override
    public void save(com.example.demo.entity.Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public com.example.demo.entity.Service findById(String serviceId) {
        return this.serviceRepository.findById(serviceId).orElse(null);
    }
}
