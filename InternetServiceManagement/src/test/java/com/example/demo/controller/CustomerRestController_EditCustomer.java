package com.example.demo.controller;

import com.example.demo.http.request.CustomerRequest;
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
public class CustomerRestController_EditCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editCustomer_13() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("Do Khoa Updated");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
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
                        .post("/customer/edit/{id}")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void editCustomer_14() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(null);
        customer.setFullName(null);
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
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
    public void createCustomer_15() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-2015");
        customer.setEmail("abc@gmail.com");
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
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
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
    public void createCustomer_17() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("0901630");
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
    public void createCustomer_18() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("0901630920");
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
    public void createCustomer_19() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(573573);
        customer.setFullName("Do Khoa");
        customer.setDateOfBirth("06-09-1998");
        customer.setEmail("abc@gmail.com");
        customer.setProvince("Hai Chau");
        customer.setDistrict("Thanh Binh");
        customer.setCommune("50");
        customer.setPhone("0901630920");
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
}
