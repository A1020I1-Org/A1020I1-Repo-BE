package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Page<Employee> getAllEmployee(Pageable pageable);

    Employee findById(String id);

    void deleteEmployee(String id);

    Page<Employee> searchEmployee(String idEmp, String dateStart,
                                  String dateEnd, String workStart, String workEnd,
                                  String address, String positionId, Pageable pageable);

    List<Employee> findAll();
}
