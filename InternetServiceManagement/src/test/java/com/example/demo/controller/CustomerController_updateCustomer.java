package com.example.demo.controller;

import com.example.demo.entity.CustomerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
    public void updateCustomer_13() throws Exception {
        CustomerDTO customer = new CustomerDTO();
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
                                .post("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_14() throws Exception {
        CustomerDTO customer = new CustomerDTO();
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
                                .post("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_15() throws Exception {
        CustomerDTO customer = new CustomerDTO();
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
                                .post("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_16() throws Exception {
        CustomerDTO customer = new CustomerDTO();
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
                                .post("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_17() throws Exception {
        CustomerDTO customer = new CustomerDTO();
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
                                .post("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_18() throws Exception {
        CustomerDTO customer = new CustomerDTO();
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
                                .post("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
