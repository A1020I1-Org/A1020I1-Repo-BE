package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> getAllEmployee(Pageable pageable);

    Employee findById(String id);

    void deleteEmployee(String id);

    Page<Employee> searchEmployee(String id, String date1, String date2, String work1, String work2, String address, String positionName, Pageable pageable);
}
