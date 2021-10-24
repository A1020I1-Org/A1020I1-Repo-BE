package com.example.demo.service;

import com.example.demo.dto.AccountEmployee;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee findById(String id);

    void saveEmployee(Employee employee);
    void updateEmployee(AccountEmployee accountEmployee, String id);

}
