package com.example.demo.controller;

import com.example.demo.entity.OrderServiceDTO;
import com.example.demo.entity.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderController_createOrderService {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createService_13() throws Exception {
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
        orderServiceDTO.setId(null);
        orderServiceDTO.setQuantity(2);
        orderServiceDTO.setUnit("lon");
        orderServiceDTO.setTotalMoney(40000);
        orderServiceDTO.setOderDate("2021-10-10");
        orderServiceDTO.setStatus(true);
        orderServiceDTO.setCustomer(1);
        orderServiceDTO.setPay(1);
        orderServiceDTO.setService("1");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderServiceDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createService_14() throws Exception {
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
        orderServiceDTO.setId(null);
        orderServiceDTO.setQuantity(2);
        orderServiceDTO.setUnit("lon");
        orderServiceDTO.setTotalMoney(40000);
        orderServiceDTO.setOderDate("2021-10-10");
        orderServiceDTO.setStatus(true);
        orderServiceDTO.setCustomer(1);
        orderServiceDTO.setPay(1);
        orderServiceDTO.setService("1");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderServiceDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createService_15() throws Exception {
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
        orderServiceDTO.setId(null);
        orderServiceDTO.setQuantity(2);
        orderServiceDTO.setUnit("lon");
        orderServiceDTO.setTotalMoney(40000);
        orderServiceDTO.setOderDate("2021-10-10");
        orderServiceDTO.setStatus(true);
        orderServiceDTO.setCustomer(1);
        orderServiceDTO.setPay(1);
        orderServiceDTO.setService("1");


        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderServiceDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createService_16() throws Exception {
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
        orderServiceDTO.setId(null);
        orderServiceDTO.setQuantity(2);
        orderServiceDTO.setUnit("lon");
        orderServiceDTO.setTotalMoney(40000);
        orderServiceDTO.setOderDate("2021-10-10");
        orderServiceDTO.setStatus(true);
        orderServiceDTO.setCustomer(1);
        orderServiceDTO.setPay(1);
        orderServiceDTO.setService("1");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderServiceDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    @Test
//    public void createService_17() throws Exception {
//        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
//        orderServiceDTO.setId(null);
//        orderServiceDTO.setQuantity(2);
//        orderServiceDTO.setUnit("lon");
//        orderServiceDTO.setTotalMoney(40000);
//        orderServiceDTO.setOderDate("2021-10-10");
//        orderServiceDTO.setStatus(true);
//        orderServiceDTO.setCustomer("1");
//        orderServiceDTO.setPay(1);
//        orderServiceDTO.setService("1");
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/order/create-order-service")
//                                .content(this.objectMapper.writeValueAsString(orderServiceDTO))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    @Test
    public void createService_18() throws Exception {
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
        orderServiceDTO.setId(null);
        orderServiceDTO.setQuantity(1);
        orderServiceDTO.setUnit("mi tom");
        orderServiceDTO.setTotalMoney(20000);
        orderServiceDTO.setOderDate("2021-10-10");
        orderServiceDTO.setStatus(false);
        orderServiceDTO.setCustomer(1);
        orderServiceDTO.setPay(1);
        orderServiceDTO.setService("2");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderServiceDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
