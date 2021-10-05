package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

    @Qualifier("serviceRepositoryImpl")
    @Autowired
    private ServiceService serviceService;

    @GetMapping(value = "/list-service")
    public ResponseEntity<List<Service>> listAllService(){
        List<Service> serviceList = serviceService.findAllService();
        if (serviceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList,HttpStatus.OK);
    }

    @GetMapping(value = "/list-serice/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Service> getService(@PathVariable("serviceId") String serviceId){
        System.out.println("Fetching Service with serviceId" + serviceId);
        Service service =serviceService.findServiceById(serviceId);
        if (service == null){
            System.out.println("Service witd serviceId" + serviceId + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
    @DeleteMapping(value = "/list-service/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable("serviceId") String serviceId){
        System.out.println("Fetching and Deleting Service with service id" + serviceId);
        Service service = serviceService.findServiceById(serviceId);

        if (service == null){
            System.out.println("Unable to delete. Service with serviceId" + serviceId + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serviceService.deleteService(serviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
