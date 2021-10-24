package com.example.demo.controller;

import com.example.demo.dto.AccountEmployee;
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
@CrossOrigin("http://localhost:4200/")
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
    public ResponseEntity<List<FieldError>> createEmployee(@RequestBody @Valid AccountEmployee accountEmployee, BindingResult bindingResult) {
        System.out.println();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Account account = new Account(accountEmployee.getUserName(), accountEmployee.getPassword());
        accountService.save(account);
        AccountRoleKey accountRoleKey = new AccountRoleKey(account.getUserName(), 1);
        Role role = roleService.findById(1);
        AccountRole accountRole = new AccountRole(accountRoleKey, account, role);
        accountRoleService.save(accountRole);
        Position position = positionService.findByID(accountEmployee.getPositionId());

        Employee employee = new Employee(accountEmployee.getEmployeeId(), accountEmployee.getFullName(), accountEmployee.getDateOfBirth(),
                accountEmployee.getEmail(), accountEmployee.getAddress(), accountEmployee.getPhone(), accountEmployee.getLevel(),
                accountEmployee.getStartWorkDate(), accountEmployee.getYearOfExp(), accountEmployee.getAvtUrl(), account, position);
        employeeService.saveEmployee(employee);
        System.out.println("tạo mới thành công");
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<AccountEmployee> updateEmployee(@Valid @RequestBody AccountEmployee accountEmployees, BindingResult bindingResult, @PathVariable String id) {
        Employee employeeObj = this.employeeService.findById(id);
        if(!bindingResult.hasErrors() && id != null){
                employeeService.updateEmployee(accountEmployees, id);
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

}
    @GetMapping(value = "/viewEmployee/{id}")
    public ResponseEntity<AccountEmployee> detailEmployee(@PathVariable String id) {
        Employee employeeObj = this.employeeService.findById(id);
        if (employeeObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AccountEmployee accountEmployee = new AccountEmployee(employeeObj.getEmployeeId(), employeeObj.getFullName(), employeeObj.getDateOfBirth(),
                employeeObj.getEmail(), employeeObj.getAddress(), employeeObj.getPhone(), employeeObj.getLevel(), employeeObj.getStartWorkDate(),
                employeeObj.getYearOfExp(), employeeObj.getAvtUrl(), employeeObj.getPosition().getPositionId(),
                employeeObj.getAccount().getUserName(), employeeObj.getAccount().getPassword());

        return new ResponseEntity<>(accountEmployee, HttpStatus.OK);
    }
}
