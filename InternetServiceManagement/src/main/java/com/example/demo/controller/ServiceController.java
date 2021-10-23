package com.example.demo.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
}
=======
import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<Page<Service>> listAllService(@PageableDefault(size = 4) Pageable pageable) {
        Page<Service> serviceList = serviceService.findAllService(pageable);
        if (serviceList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Service> post(@Valid @RequestBody Service service, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            this.serviceService.save(service);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Service> update(@Valid @RequestBody Service service,
                                          BindingResult bindingResult,
                                          @PathVariable String id) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            this.serviceService.save(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable("id") String serviceId) {
        System.out.println("Fetching and Deleting Service with service id" + serviceId);
        Service service = serviceService.findServiceById(serviceId);

        if (service == null) {
            System.out.println("Unable to delete. Service with serviceId" + serviceId + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/search")
    public ResponseEntity<Page<Service>> searchService(@RequestParam("searchName") String searchName,
                                                       @PageableDefault(size = 3) Pageable pageable) {
        Page<Service> searchService = serviceService.search(pageable, searchName);
        System.out.println(searchService);
        if (searchService == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchService, HttpStatus.OK);
    }
}

>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
