package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

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
    public ResponseEntity<Computer> update(@Valid @RequestBody Computer computer, @PathVariable String id) {
        this.computerService.findById(id);
        if (this.computerService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            this.computerService.save(computer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
  
   @GetMapping("/listComputer")
    public ResponseEntity<Page<Computer>> listComputer(@PageableDefault(size = 4) Pageable pageable) {
        Page<Computer> computerList = computerService.finAll(pageable);
        if (computerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computerList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteComputer/{id}")
    public ResponseEntity<Computer> deleteComputer(@PathVariable String id) {
        Computer computer = computerService.findById(id);
        if (computer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/searchComputer")
    public ResponseEntity<Page<Computer>> searchComputer(@RequestParam("computerId") String id,
                                                         @RequestParam("computerLocation") String computerLocation,
                                                         @RequestParam("computerStartUsedDate") String computerStartUsedDate,
                                                         @RequestParam("computerStartUsedTo") String computerStartUsedTo,
                                                         @RequestParam("type") String type,
                                                         @RequestParam("status") String status,
                                                         @PageableDefault(size = 4) Pageable pageable) {
        Page<Computer> computers = computerService.search(id, computerLocation, computerStartUsedDate,computerStartUsedTo, type, status,pageable);
        if (computers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);

    }
  
}


