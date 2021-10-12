package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ServiceService {

    void save(Service service);

    Service findById(String serviceId);

    List<Service> findAllService();

    Service findServiceById(String serviceId);

    Service deleteService (String serviceId);

    Page<Service> search(Pageable pageable, String searchName);
}

