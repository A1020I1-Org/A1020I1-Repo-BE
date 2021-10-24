package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_infoCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetInfoCustomer_1() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetInfoCustomer_2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetInfoCustomer_3() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetInfoCustomer_4() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.fullName").value("ngoc cuong"))
                .andExpect(jsonPath("$.dateOfBirth").value("1998-06-09"))
                .andExpect(jsonPath("$.email").value("cuong3412@gmail.com"))
                .andExpect(jsonPath("$.address").value("Thành phố Đà Nẵng,Quận Liên Chiểu,Phường Hòa Khánh Băc"))
                .andExpect(jsonPath("$.phone").value("0901630920"))
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.userName").value("test123"));

    }
}
