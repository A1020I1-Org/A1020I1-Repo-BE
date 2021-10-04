package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/computer")
public class ComputerController {
    @Autowired
    ComputerService computerService;
    @GetMapping("/listComputer")
    public ResponseEntity<List<Computer>> listComputer(){
        List<Computer> computerList = computerService.finAll();
        if(computerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computerList,HttpStatus.OK);
    }
    @DeleteMapping("/deleteComputer")
    public ResponseEntity<Computer> deleteComputer(@PathVariable String id){
        Computer computer = computerService.findById(id);
        if (computer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
