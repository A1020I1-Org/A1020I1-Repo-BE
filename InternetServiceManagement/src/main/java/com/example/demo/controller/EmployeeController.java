package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<FieldError>> createEmployee(@RequestBody @Valid AccountEmployee accountEmployee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        if (accountService.checkUserName(accountEmployee.getUserName())){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
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
        employeeService.saveEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<List<FieldError>> updateEmployee(@PathVariable @Valid String id, @RequestBody AccountEmployee accountEmployee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        if (accountService.checkUserName(accountEmployee.getUserName())){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
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
        return new ResponseEntity<>(headers, HttpStatus.CREATED);

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
