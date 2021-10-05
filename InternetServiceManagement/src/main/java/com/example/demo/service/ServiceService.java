package com.example.demo.service;

import com.example.demo.entity.Service;

import java.util.List;
@org.springframework.stereotype.Service
public interface ServiceService {

    List<Service> findAllService();

    Service findServiceById(String serviceId);

    Service deleteService (String serviceId);
}
