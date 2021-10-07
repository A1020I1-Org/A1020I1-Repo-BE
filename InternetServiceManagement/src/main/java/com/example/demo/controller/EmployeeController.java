package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Employee> createEmployee(@RequestBody AccountEmployee accountEmployee){
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
        return new ResponseEntity<Employee>(headers, HttpStatus.CREATED);
    }


//    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
//    public String createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder){
//        System.out.println("Tạo mới thành công nhân viên " + employee.getFullName());
//        employeeService.saveEmployee(employee);
//
//        return "redirect:/employee/show";
//    }

//    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Employee> updateEmployee(@PathVariable String id){
//        Employee employee = employeeService.findById(id);
//        if(employee == null){
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//
//        }
//        employeeService.updateEmployee(employee);
//
//        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee){
//        System.out.println("Cập nhật thành công nhân viên" + id);
//
//        Employee currentEmployee = employeeService.findById(id);
//        if(currentEmployee == null){
//            System.out.println("Nhân viên với mã nhân viên" + id + "Không tìm thấy");
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//        }
//
//        currentEmployee.setFullName(employee.getFullName());
//        currentEmployee.setDateOfBirth(employee.getDateOfBirth());
//        currentEmployee.setEmail(employee.getEmail());
//        currentEmployee.setPhone(employee.getPhone());
//        currentEmployee.setAddress(employee.getAddress());
//        currentEmployee.setLevel(employee.getLevel());
//        currentEmployee.setStartWorkDate(employee.getStartWorkDate());
//        currentEmployee.setYearOfExp(employee.getYearOfExp());
//        currentEmployee.setPosition(employee.getPosition());
//        currentEmployee.setAvtUrl(employee.getAvtUrl());
//        currentEmployee.setAccount(employee.getAccount());
//
//
//        employeeService.updateEmployee(currentEmployee);
//        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
//    }
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee){
        if (this.employeeService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.employeeService.saveEmployee(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/viewEmployee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> detailEmployee(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Nhân viên có mã nhân viên " + id + " không tìm thấy");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}
