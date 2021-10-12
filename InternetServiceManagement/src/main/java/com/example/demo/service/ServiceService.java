package com.example.demo.service;

import com.example.demo.entity.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceService {

    // thanh test
    Page<Service> pageService(Pageable pageable);

    void save(Service service);

    Service findById(String serviceId);

    List<Service> findAllService();

    Service findServiceById(String serviceId);

    Service deleteService (String serviceId);

    Page<Service> search(Pageable pageable, String searchName);
}

