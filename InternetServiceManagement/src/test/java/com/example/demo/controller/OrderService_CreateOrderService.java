package com.example.demo.controller;

import com.example.demo.entity.OrderService;
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
public class OrderService_CreateOrderService {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createService_13() throws Exception {
        OrderService orderService = new OrderService();
        orderService.setId(null);
        orderService.setQuantity(2);
        orderService.setUnit("lon");
        orderService.setTotalMoney(40000);
        orderService.setOder_date("2021-10-10");
        orderService.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderService))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createService_14() throws Exception {
        OrderService orderService = new OrderService();
        orderService.setId(1);
        orderService.setQuantity(2);
        orderService.setUnit("");
        orderService.setTotalMoney(40000);
        orderService.setOder_date("2021-10-10");
        orderService.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderService))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createService_15() throws Exception {
        OrderService orderService = new OrderService();
        orderService.setId(1);
        orderService.setQuantity(2);
        orderService.setUnit("lon");
        orderService.setTotalMoney(40000);
        orderService.setOder_date("2021-10-10");
        orderService.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderService))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createService_16() throws Exception {
        OrderService orderService = new OrderService();
        orderService.setId(1);
        orderService.setQuantity(0);
        orderService.setUnit("lon");
        orderService.setTotalMoney(40000);
        orderService.setOder_date("2021-10-10");
        orderService.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderService))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    @Test
//    public void createService_17() throws Exception {
//        OrderService orderService = new OrderService();
//        orderService.setId(1);
//        orderService.setQuantity(99999999999);
//        orderService.setUnit("lon");
//        orderService.setTotalMoney(40000);
//        orderService.setOder_date("2021-10-10");
//        orderService.setStatus(true);
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .post("/order/create-order-service")
//                                .content(this.objectMapper.writeValueAsString(orderService))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    @Test
    public void createService_18() throws Exception {
        OrderService orderService = new OrderService();
        orderService.setId(1);
        orderService.setQuantity(2);
        orderService.setUnit("lon");
        orderService.setTotalMoney(40000);
        orderService.setOder_date("2021-10-10");
        orderService.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/order/create-order-service")
                                .content(this.objectMapper.writeValueAsString(orderService))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
