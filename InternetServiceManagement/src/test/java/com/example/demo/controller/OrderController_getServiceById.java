package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderController_getServiceById {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getServiceById_1() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/order/service/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getServiceById_2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/order/service/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getServiceById_3() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/order/service/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getServiceById_4() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/order/service/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customer.customer_id").value(1))
                .andExpect(jsonPath("$.service.service_id").value(1))
                .andExpect(jsonPath("$.pay.pay_id").value(1))
                .andExpect(jsonPath("$.quantity").value(2))
                .andExpect(jsonPath("$.unit").value("0987654321"))
                .andExpect(jsonPath("$.totalMoney").value(20000))
                .andExpect(jsonPath("$.oder_date").value("2021-10-10"))
                .andExpect(jsonPath("$.status").value(true));
    }
}
