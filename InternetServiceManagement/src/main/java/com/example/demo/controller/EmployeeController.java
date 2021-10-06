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
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(size = 4) Pageable pageable) {
        Page<Employee> employeeList = employeeService.getAllEmployee(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
    public ResponseEntity<Page<Employee>> searchEmployee(@RequestParam(value = "id") String id,
                                                         @RequestParam(value = "date1") String date1,
                                                         @RequestParam(value = "date2") String date2,
                                                         @RequestParam(value = "work1") String work1,
                                                         @RequestParam(value = "work2") String work2,
                                                         @RequestParam(value = "address") String address,
                                                         @RequestParam(value = "positionName") String positionName,
                                                         @PageableDefault(size = 4) Pageable pageable) {
        Page<Employee> employeeList = employeeService.searchEmployee(id,date1,date2,work1,work2,address,positionName,pageable);
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
