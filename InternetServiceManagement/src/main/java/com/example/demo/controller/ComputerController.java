package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/computer")
@CrossOrigin("http://localhost:4200")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @PostMapping("/create")
    public ResponseEntity<Computer> post(@Valid @RequestBody Computer computer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            this.computerService.save(computer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<Computer> update(@Valid @RequestBody Computer computer,  BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            this.computerService.findById(id);
            this.computerService.save(computer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
