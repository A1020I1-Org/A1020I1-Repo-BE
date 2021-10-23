package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee findById(String id);

    void saveEmployee(Employee employee);

    Page<Employee> searchEmployee(String idEmp, String dateStart,
                                  String dateEnd, String workStart, String workEnd,
                                  String address, String positionId, Pageable pageable);

    List<Employee> findAll();
    void deleteEmployee(String id);
    void updateEmployee(Employee employee);
}
