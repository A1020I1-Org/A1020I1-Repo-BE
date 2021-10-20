package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> searchEmployee(String idEmp, String dateStart, String dateEnd,
                                         String workStart, String workEnd, String address,
                                         String positionId, Pageable pageable) {
        return employeeRepository.searchEmployee(idEmp,dateStart,dateEnd,workStart,workEnd,address,positionId,pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
