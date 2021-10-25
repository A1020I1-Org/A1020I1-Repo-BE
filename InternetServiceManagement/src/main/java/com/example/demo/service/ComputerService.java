package com.example.demo.service;

import com.example.demo.entity.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ComputerService {
  
    Page<Computer> finAll(Pageable pageable);
  
    Computer findById(int id);
  
    void delete (int id);
  
    Page<Computer> search(int id, String computerLocation, String computerStartUsedFrom, String computerStartUsedTo, String type, String status,Pageable pageable);

    void save(Computer computer);

    void update(Computer computer, int id);

    Computer findByIpHost(String ip);

}
