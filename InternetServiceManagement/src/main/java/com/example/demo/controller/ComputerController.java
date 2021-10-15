package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.entity.Status;
import com.example.demo.entity.Type;
import com.example.demo.repository.TypeComputerRepository;
import com.example.demo.service.ComputerService;
import com.example.demo.service.StatusComputerService;
import com.example.demo.service.TypeComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/computer")
@CrossOrigin("http://localhost:4200")
public class ComputerController {

    @Autowired
    ComputerService computerService;
    @Autowired
    TypeComputerService typeComputerService;
    @Autowired
    StatusComputerService statusComputerService;

    @GetMapping("/typeComputer")
    public ResponseEntity<List<Type>> listTypeComputer(){
        List<Type> typeList = typeComputerService.finAllType();
        if (typeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }
    @GetMapping("/statusComputer")
    public ResponseEntity<List<Status>> listStatusComputer(){
        List<Status> statusList = statusComputerService.finAll();
        if (statusList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }
    @GetMapping("/listComputer")
    public ResponseEntity<Page<Computer>> listComputer(@PageableDefault(size = 4) Pageable pageable) {
        Page<Computer> computerList = computerService.finAll(pageable);
        if (computerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computerList, HttpStatus.OK);
    }
    @GetMapping("/getInforComputer/{id}")
    public ResponseEntity<Computer> getInforComputer(@PathVariable String id){
        Computer computer = computerService.findById(id);
        if (computer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computer, HttpStatus.OK);
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
                                                         @RequestParam("startUsedDateFromComputer") String startUsedDateFromComputer,
                                                         @RequestParam("startUsedDateToComputer") String startUsedDateToComputer,
                                                         @RequestParam("type") String type,
                                                         @RequestParam("status") String status,
                                                         @PageableDefault(size = 4) Pageable pageable) {


        Page<Computer> computers = computerService.search(id, computerLocation, startUsedDateFromComputer,startUsedDateToComputer, type, status,pageable);
        if (computers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);

    }
}
