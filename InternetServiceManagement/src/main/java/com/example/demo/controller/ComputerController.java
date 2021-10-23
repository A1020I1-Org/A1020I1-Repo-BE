package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.entity.Type;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<Computer> edit(@PathVariable int id) {
        Computer computer = computerService.findById(id);
        if (computer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(computer, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Computer> update(@Valid @RequestBody Computer computer, BindingResult bindingResult, @PathVariable Integer id) {
        System.out.println(id);
//        if (bindingResult.hasFieldErrors()) {
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        } else {
//            this.computerService.save(computer);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
        if (!bindingResult.hasErrors() && id != null) {
            if (computerService.findById(id) != null) {
                computerService.update(computer, id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}



