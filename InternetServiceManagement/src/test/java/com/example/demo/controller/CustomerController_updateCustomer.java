package com.example.demo.controller;

import com.example.demo.entity.Customer;
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
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1999-10-17");
        customer.setEmail("cuong@gmail.com");
        customer.setAddress("da nang");
        customer.setPhone("098765432");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/null")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_20() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setFullName("");
        customer.setDateOfBirth("1999-10-17");
        customer.setEmail("cuong@gmail.com");
        customer.setAddress("da nang");
        customer.setPhone("098765432");

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
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1999-10-17");
        customer.setEmail("cuong@gmail.com");
        customer.setAddress("da nang");
        customer.setPhone("098765432");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .patch("/customer/update/1")
                                .content(this.objectMapper.writeValueAsString(customer))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    @Test
//    public void updateCustomer_22() throws Exception {
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        customer.setFullName("ngoc cuong");
//        customer.setDateOfBirth("1999-10-17");
//        customer.setEmail("cuong@gmail.com");
//        customer.setAddress("da nang");
//        customer.setPhone("098765432");
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .patch("/customer/update/1")
//                                .content(this.objectMapper.writeValueAsString(customer))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateCustomer_23() throws Exception {
//        Customer customer = new Customer();
//        customer.setCustomerId("1");
//        customer.setFullName("ngoc cuong");
//        customer.setDateOfBirth("1999-10-17");
//        customer.setEmail("cuong@gmail.com");
//        customer.setAddress("da nang");
//        customer.setPhone("098765432");
//
//        this.mockMvc
//                .perform(
//                        MockMvcRequestBuilders
//                                .patch("/customer/update/1")
//                                .content(this.objectMapper.writeValueAsString(customer))
//                                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    @Test
    public void updateCustomer_24() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setFullName("ngoc cuong");
        customer.setDateOfBirth("1999-10-17");
        customer.setEmail("cuong@gmail.com");
        customer.setAddress("da nang");
        customer.setPhone("098765432");
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
