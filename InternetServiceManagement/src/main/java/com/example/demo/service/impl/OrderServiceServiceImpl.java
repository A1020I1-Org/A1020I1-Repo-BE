package com.example.demo.service.impl;

import com.example.demo.entity.OrderService;
import com.example.demo.entity.OrderServiceDTO;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderServiceRepository;
import com.example.demo.service.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceServiceImpl implements OrderServiceService {
    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderService findById(String id) {
        return orderServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void createOrderService(OrderServiceDTO orderServiceDTO) {
        OrderService orderService = toEntity(orderServiceDTO);
//        Customer customer = new Customer();
//        Pay pay = new Pay();
//        pay.setId(orderServiceDTO.getPay());
//
//        com.example.demo.entity.Service service = new com.example.demo.entity.Service();
//
//        orderService.setCustomer(customer);
//        orderService.setPay(pay);
//        orderService.setService(service);

        orderServiceRepository.save(orderService);
    }

    private OrderServiceDTO toDTO(OrderService orderService){
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
        orderServiceDTO.setId(orderService.getId());
        orderServiceDTO.setQuantity(orderService.getQuantity());
        orderServiceDTO.setUnit(orderService.getUnit());
        orderServiceDTO.setTotalMoney(orderService.getTotalMoney());
        orderServiceDTO.setOderDate(orderService.getOder_date());
        orderServiceDTO.setStatus(orderService.isStatus());
        orderServiceDTO.setCustomer(orderService.getCustomer().getCustomerId());
        orderServiceDTO.setService(orderService.getService().getServiceId());
        orderServiceDTO.setPay(orderService.getPay().getId());
        return orderServiceDTO;
    }

    private OrderService toEntity(OrderServiceDTO orderServiceDTO){
        OrderService orderService = new OrderService();
        if (orderServiceDTO.getId() != null) {
            Optional<OrderService> orderService1 = orderServiceRepository.findById(orderServiceDTO.getId());
            if (orderService1.isPresent()) {
                orderService = orderService1.get();
            }
        }
        orderService.setQuantity(orderServiceDTO.getQuantity());
        orderService.setUnit(orderServiceDTO.getUnit());
        orderService.setTotalMoney(orderServiceDTO.getTotalMoney());
        orderService.setOder_date(orderServiceDTO.getOderDate());
        orderService.setStatus(orderServiceDTO.getStatus());

        return orderService;
    }
}
