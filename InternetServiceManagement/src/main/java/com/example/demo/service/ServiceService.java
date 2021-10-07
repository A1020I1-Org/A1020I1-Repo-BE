package com.example.demo.service;

import com.example.demo.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
@org.springframework.stereotype.Service
public interface ServiceService {

    List<Service> findAllService();

    Service findServiceById(String serviceId);

    Service deleteService (String serviceId);

    Page<Service> search(Pageable pageable, String searchName);
}

