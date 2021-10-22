package com.example.demo.controller;

import com.example.demo.entity.AccountCustomer;
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
public class CustomerRestController_CreateCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createCustomer_13() throws Exception {
        AccountCustomer customer = new AccountCustomer();
        customer.setCustomerId(null);
        customer.setFullName(null);
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("abc123@gmail.com");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("0901630920");
        customer.setUsername("xyz1234");
        customer.setPassword("Khoadvd48!");
        customer.setPasswordRetype("Khoadvd48!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_14() throws Exception {
        AccountCustomer customer = new AccountCustomer();
        customer.setCustomerId(null);
        customer.setFullName("");
        customer.setDateOfBirth("2015-06-09");
        customer.setEmail("");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("0901630920");
        customer.setUsername("khoadvd123");
        customer.setPassword("Khoadvd48!");
        customer.setPasswordRetype("Khoadvd48!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_15() throws Exception {
        AccountCustomer customer = new AccountCustomer();
        customer.setCustomerId(null);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abcgmailcom");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("0901630920");
        customer.setUsername("khoadvd1998");
        customer.setPassword("Khoadvd48!");
        customer.setPasswordRetype("Khoadvd48!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_16() throws Exception {
        AccountCustomer customer = new AccountCustomer();
        customer.setCustomerId(null);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("090163");
        customer.setUsername("khoadvd1998");
        customer.setPassword("Khoadvd48!");
        customer.setPasswordRetype("Khoadvd48!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_17() throws Exception {
        AccountCustomer customer = new AccountCustomer();
        customer.setCustomerId(null);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("09016309200909079896969");
        customer.setUsername("khoadvd1998");
        customer.setPassword("Khoadvd48!");
        customer.setPasswordRetype("Khoadvd858!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_18() throws Exception {
        AccountCustomer customer = new AccountCustomer();
        customer.setCustomerId(null);
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong34@gmail.com");
        customer.setProvince("Thanh phố Đà Nẵng");
        customer.setDistrict("Quận Liên Chiểu");
        customer.setCommune("Phường Hòa Khánh Băc");
        customer.setPhone("0901630920");
        customer.setUsername("test123");
        customer.setPassword("Cuong123!");
        customer.setPasswordRetype("Cuong123!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
