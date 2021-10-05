package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ModelAttribute("listEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }


    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public String createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder){
        System.out.println("Tạo mới thành công nhân viên " + employee.getFullName());
        employeeService.saveEmployee(employee);

        return "redirect:/employee/show";
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable String id,@RequestBody Employee employee){
        Employee employee1 = employeeService.findById(id);
        if(employee1 == null){
            System.out.println("Nhân viên với mã nhân viên" + id + "Không tìm thấy");

        }
        employeeService.updateEmployee(employee);

        return null;
    }
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


    @RequestMapping(value = "/viewEmployee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Nhân viên có mã nhân viên " + id + " không tìm thấy");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}
