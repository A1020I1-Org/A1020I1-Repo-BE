package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/service")
@CrossOrigin("http://localhost:4200")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // of thanh test
    @GetMapping("/list")
    public ResponseEntity<List<Service>> get(){
        return new ResponseEntity<>(this.serviceService.findAllService(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Service>> page(@PageableDefault(value = 3) Pageable pageable){
        return new ResponseEntity<>(this.serviceService.pageService(pageable), HttpStatus.OK);
    }
    // of thanh test

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
    public ResponseEntity<Service> update(@Valid @RequestBody Service service,
                                          BindingResult bindingResult,
                                          @PathVariable String id){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            this.serviceService.save(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
