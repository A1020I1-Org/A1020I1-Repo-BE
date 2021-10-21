package com.example.demo.service;

import com.example.demo.entity.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    Service findById(String id);

    void save(Service service);

    void delete(Service service);
}
