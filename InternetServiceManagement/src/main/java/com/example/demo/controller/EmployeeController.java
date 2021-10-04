package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Position;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionService positionService;

    @ModelAttribute("positions")
    public List<Position> showAllPosition() {
        return positionService.findAll();
    }

    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
