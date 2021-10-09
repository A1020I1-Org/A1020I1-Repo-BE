package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/create")
    public ResponseEntity<Service> post(@Valid @RequestBody Service service, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            this.serviceService.save(service);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Service> update(@PathVariable String id,
                                          @Valid @RequestBody Service service,
                                          BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            this.serviceService.save(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
