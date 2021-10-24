package com.example.demo.controller;

import com.example.demo.entity.AccountCustomer;
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
        customer.setFullName(null);
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong3412@gmail.com");
        customer.setProvince("Thanh phố Đà Nẵng");
        customer.setDistrict("Quận Liên Chiểu");
        customer.setCommune("Phường Hòa Khánh Băc");
        customer.setPhone("0901630920");
        customer.setUsername("test1234");
        customer.setPassword("Cuong123!");
        customer.setPasswordRetype("Cuong123!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_14() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("");
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong34@gmail.com");
        customer.setProvince("Thanh phố Đà Nẵng");
        customer.setDistrict("Quận Liên Chiểu");
        customer.setCommune("Phường Hòa Khánh Băc");
        customer.setPhone("0901630920");
        customer.setUsername("test1234");
        customer.setPassword("Cuong123!");
        customer.setPasswordRetype("Cuong123!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_15() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong34@gmail.com");
        customer.setProvince("Thanh phố Đà Nẵng");
        customer.setDistrict("Quận Liên Chiểu");
        customer.setCommune("Phường Hòa Khánh Băc");
        customer.setPhone("0901630920");
        customer.setUsername("test1234");
        customer.setPassword("Cuong123!");
        customer.setPasswordRetype("Cuong123!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_16() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong34@gmail.com");
        customer.setProvince("Thanh phố Đà Nẵng");
        customer.setDistrict("Quận Liên Chiểu");
        customer.setCommune("Phường Hòa Khánh Băc");
        customer.setPhone("090");
        customer.setUsername("test1234");
        customer.setPassword("Cuong123!");
        customer.setPasswordRetype("Cuong123!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_17() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong34@gmail.com");
        customer.setProvince("Thanh phố Đà Nẵng");
        customer.setDistrict("Quận Liên Chiểu");
        customer.setCommune("Phường Hòa Khánh Băc");
        customer.setPhone("090163092012312312312");
        customer.setUsername("test1234");
        customer.setPassword("Cuong123!");
        customer.setPasswordRetype("Cuong123!");
        customer.setStatus(true);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editCustomer_18() throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.setCustomerId(1);
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1998-06-09");
        customer.setEmail("cuong@gmail.com");
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
                        .put("/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
