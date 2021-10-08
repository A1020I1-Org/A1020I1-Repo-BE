package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    AccountRoleService accountRoleService;

    @Autowired
    PositionService positionService;


    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid AccountEmployee accountEmployee){
        Account account = new Account(accountEmployee.getUserName(), accountEmployee.getPassword());
        accountService.save(account);
        AccountRoleKey accountRoleKey = new AccountRoleKey(account.getUserName(),1);
        Role role = roleService.findById(1);
        AccountRole accountRole = new AccountRole(accountRoleKey,account,role);
        accountRoleService.save(accountRole);
        Position position = positionService.findByID(accountEmployee.getIdPosition());

        Employee employee = new Employee(accountEmployee.getEmployeeId(),accountEmployee.getFullName(),accountEmployee.getDateOfBirth(),
                accountEmployee.getEmail(),accountEmployee.getAddress(),accountEmployee.getPhone(),accountEmployee.getLevel(),
                accountEmployee.getStartWorkDate(), accountEmployee.getYearOfExp(), accountEmployee.getAvtUrl(), account,position);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


//    @PutMapping("/updateEmployee/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee){
//        if (this.employeeService.findById(id) == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }else {
//            this.employeeService.saveEmployee(employee);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody AccountEmployee accountEmployee){
        if(this.employeeService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Account account = new Account(accountEmployee.getUserName(), accountEmployee.getPassword());
        accountService.save(account);
        AccountRoleKey accountRoleKey = new AccountRoleKey(account.getUserName(),1);
        Role role = roleService.findById(1);
        AccountRole accountRole = new AccountRole(accountRoleKey,account,role);
        accountRoleService.save(accountRole);
        Position position = positionService.findByID(accountEmployee.getIdPosition());

        Employee employee = new Employee(accountEmployee.getEmployeeId(),accountEmployee.getFullName(),accountEmployee.getDateOfBirth(),
                accountEmployee.getEmail(),accountEmployee.getAddress(),accountEmployee.getPhone(),accountEmployee.getLevel(),
                accountEmployee.getStartWorkDate(), accountEmployee.getYearOfExp(), accountEmployee.getAvtUrl(), account,position);
        employeeService.updateEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Employee>(headers, HttpStatus.CREATED);

    }

    @GetMapping(value = "/viewEmployee/{id}")
    public ResponseEntity<Employee> detailEmployee(@PathVariable String id) {
        Employee employeeObj = this.employeeService.findById(id);
        if (employeeObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeObj, HttpStatus.OK);
    }
}
