package com.example.demo.service;

import com.example.demo.entity.Service;

import java.util.List;

public interface ServiceService {

    void save(Service service);

    Service findById(String serviceId);
}
