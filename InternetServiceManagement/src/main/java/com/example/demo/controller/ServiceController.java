package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/create")
    public ResponseEntity<Service> post(@RequestBody Service service) {
        this.serviceService.save(service);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Service> update(@PathVariable String id, @RequestBody Service service){
        if (this.serviceService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.serviceService.save(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
