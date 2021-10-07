package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_deleteEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDeleteEmployee_25() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteEmployee/{id}","null"))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDeleteEmployee_26() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteEmployee/{id}",""))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDeleteEmployee_27() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteEmployee/{id}","123"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDeleteEmployee_28() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteEmployee/{id}","2"))
                .andExpect(status().is2xxSuccessful());
    }
}
