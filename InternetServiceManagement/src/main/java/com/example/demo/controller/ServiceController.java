package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

 

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Service>> listAllService(@PageableDefault(size = 5) Pageable pageable) {
        Page<Service> serviceList = serviceService.findAllService(pageable);
        if (serviceList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<Service> deleteAllService() {
         serviceService.deleteAllService();
         return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/search")
    public ResponseEntity<Page<Service>> searchService(@RequestParam("searchName") String searchName,
                                                  @PageableDefault(size = 5) Pageable pageable) {
        Page<Service> searchService = serviceService.search(pageable, searchName);
        System.out.println(searchService);
        System.out.println("abdc");
       if (searchService.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(searchService,HttpStatus.OK);
    }
}

