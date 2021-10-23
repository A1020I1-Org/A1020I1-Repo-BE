package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee findById(String id);

    void saveEmployee(Employee employee);

    void deleteEmployee(String id);
    void updateEmployee(Employee employee);
}
