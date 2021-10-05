package com.example.demo.service.impl;

import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.impl.ServiceRepositoryImpl;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public List<com.example.demo.entity.Service> findAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public com.example.demo.entity.Service findServiceById(String serviceId) {
        return (com.example.demo.entity.Service) serviceRepository.findById(serviceId).orElse(null);
    }

    @Override
    public com.example.demo.entity.Service deleteService(String serviceId) {
        serviceRepository.deleteById(serviceId);
        return null;
    }
}
