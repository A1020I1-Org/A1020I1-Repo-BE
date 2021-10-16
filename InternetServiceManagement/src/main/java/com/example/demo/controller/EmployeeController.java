package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Position;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionService positionService;

    @RequestMapping(value = "/listPosition", method = RequestMethod.GET)
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = positionService.findAll();
        if (positionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(size = 5) Pageable pageable) {
        Page<Employee> employeeList = employeeService.getAllEmployee(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
    public ResponseEntity<Page<Employee>> searchEmployee(@RequestParam String idEmp,
                                                         @RequestParam String dateStart,
                                                         @RequestParam String dateEnd,
                                                         @RequestParam String workStart,
                                                         @RequestParam String workEnd,
                                                         @RequestParam String address,
                                                         @RequestParam String positionId,
                                                         @PageableDefault(size = 5) Pageable pageable) {
        Page<Employee> employeeList = employeeService.searchEmployee(idEmp,dateStart,dateEnd,workStart
                ,workEnd,address,positionId,pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
}
