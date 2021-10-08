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
public class EmployeeController_detailEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDetailEmployee_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/viewEmployee/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDetailEmployee_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/viewEmployee/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDetailEmployee_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/viewEmployee/{id}", "NV-9999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDetailEmployee_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/viewEmployee/{id}", "NV-0003"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.fullName").value("Nguyen Trangg"))
                .andExpect(jsonPath("$.dateOfBirth").value("09-10-1999"))
                .andExpect(jsonPath("$.email").value("hoaleduc@gmail.com"));



    }

}
