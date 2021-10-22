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
    public void testGetInfoStudent_1() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetInfoStudent_2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetInfoStudent_3() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetInfoStudent_4() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customer/info/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.fullName").value("ngoc cuong"))
                .andExpect(jsonPath("$.dateOfBirth").value("1999-10-17"))
                .andExpect(jsonPath("$.email").value("cuong@gmail.com"))
                .andExpect(jsonPath("$.address").value("hue"))
                .andExpect(jsonPath("$.phone").value("01324578"))
                .andExpect(jsonPath("$.status").value(true));
    }
}
