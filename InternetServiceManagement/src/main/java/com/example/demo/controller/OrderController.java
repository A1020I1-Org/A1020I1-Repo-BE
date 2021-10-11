package com.example.demo.controller;

import com.example.demo.entity.OrderService;
import com.example.demo.entity.Service;
import com.example.demo.service.OrderServiceService;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private OrderServiceService orderServiceService;

    @GetMapping(value = "/service/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Service> getServiceById(@PathVariable("id") String id) {
        Service service = serviceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping(value = "/order-service/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderService> getServiceOrderById(@PathVariable("id") Integer id) {
        OrderService orderService = orderServiceService.findById(id);
        if (orderService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderService, HttpStatus.OK);
    }

    @PostMapping(value = "/create-order-service")
    public ResponseEntity<Void> createOrderService(@RequestBody OrderService orderService, UriComponentsBuilder ucBuilder) {
        orderServiceService.save(orderService);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/service/{id}").buildAndExpand(orderService.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


}
