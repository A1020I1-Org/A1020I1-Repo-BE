package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderService;
import com.example.demo.entity.OrderServiceDTO;
import com.example.demo.entity.Service;
import com.example.demo.service.OrderServiceService;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private OrderServiceService orderServiceService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Service>> getAllService() {
        List<Service> service = serviceService.findAll();
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping(value = "/list-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderService>> getAllOrder() {
        List<OrderService> orderServices = orderServiceService.findListOrderService();
        return new ResponseEntity<>(orderServices, HttpStatus.OK);
    }

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
    public ResponseEntity<List<OrderService>> createOrderService(@RequestBody OrderServiceDTO orderServiceDTO) {
        List<OrderService> listOrderService = orderServiceService.createOrderService(orderServiceDTO);
        return new ResponseEntity<>(listOrderService, HttpStatus.CREATED);
    }

}
