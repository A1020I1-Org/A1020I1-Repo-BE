package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerAccount;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_updateCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateCustomer_19() throws Exception {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerId("1");
        customer.setFullName(null);
        customer.setDateOfBirth("1999-17-10");
        customer.setEmail("cuong@gmail.com");
        customer.setProvince("Hoa Khanh Bac");
        customer.setDistrict("Lien Chieu");
        customer.setCommune("41");
        customer.setPhone("0987654321");
        customer.setUsername("cuong");
        customer.setPassword("123");
        customer.setPasswordRetype("123");
        customer.setStatus(true);


        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_20() throws Exception {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerId("1");
        customer.setFullName("");
        customer.setDateOfBirth("1999-17-10");
        customer.setEmail("cuong@gmail.com");
        customer.setProvince("Hoa Khanh Bac");
        customer.setDistrict("Lien Chieu");
        customer.setCommune("41");
        customer.setPhone("0987654321");
        customer.setUsername("cuong");
        customer.setPassword("123");
        customer.setPasswordRetype("123");
        customer.setStatus(true);


        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_21() throws Exception {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerId("1");
        customer.setFullName("Ngoc Cuong");
        customer.setDateOfBirth("1999-17-10");
        customer.setEmail("cuong");
        customer.setProvince("Hoa Khanh Bac");
        customer.setDistrict("Lien Chieu");
        customer.setCommune("41");
        customer.setPhone("0987654321");
        customer.setUsername("cuong");
        customer.setPassword("123");
        customer.setPasswordRetype("123");
        customer.setStatus(true);


        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_22() throws Exception {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerId("1");
        customer.setFullName("Ngoc Cuong");
        customer.setDateOfBirth("1999-17-10");
        customer.setEmail("cuong@gmail.com");
        customer.setProvince("Hoa Khanh Bac");
        customer.setDistrict("Lien Chieu");
        customer.setCommune("41");
        customer.setPhone("09");
        customer.setUsername("cuong");
        customer.setPassword("123");
        customer.setPasswordRetype("123");
        customer.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_23() throws Exception {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerId("1");
        customer.setFullName("Ngoc Cuong");
        customer.setDateOfBirth("1999-17-10");
        customer.setEmail("cuong@gmail.com");
        customer.setProvince("Hoa Khanh Bac");
        customer.setDistrict("Lien Chieu");
        customer.setCommune("41");
        customer.setPhone("0987654321111");
        customer.setUsername("cuong");
        customer.setPassword("123");
        customer.setPasswordRetype("123");
        customer.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_24() throws Exception {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerId("1");
        customer.setFullName("Ngoc Cuong");
        customer.setDateOfBirth("1999-17-10");
        customer.setEmail("cuong@gmail.com");
        customer.setProvince("Hoa Khanh Bac");
        customer.setDistrict("Lien Chieu");
        customer.setCommune("41");
        customer.setPhone("0987654321");
        customer.setUsername("cuong");
        customer.setPassword("123");
        customer.setPasswordRetype("123");
        customer.setStatus(true);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
