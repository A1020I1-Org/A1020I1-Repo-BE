package com.example.demo.service;

import com.example.demo.entity.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ComputerService {

    Page<Computer> findAll(Pageable pageable);

    List<Computer> findAll();

    Computer findById(String id);

    void save(Computer computer);

    void delete (String id);
    Page<Computer> search(String id, String computerLocation, String computerStartUsedFrom, String computerStartUsedTo, String type, String status,Pageable pageable);

}
