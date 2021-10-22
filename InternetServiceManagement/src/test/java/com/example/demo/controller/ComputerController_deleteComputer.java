package com.example.demo.controller;

import com.example.demo.service.ComputerService;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerController_deleteComputer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDeleteComputer_8() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/computer/deleteComputer/{id}","null"))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDeleteComputer_9() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/computer/deleteComputer/{id}"," "))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDeleteComputer_10() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/computer/deleteComputer/{id}","123"))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void testDeleteComputer_11() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/computer/deleteComputer/{id}","CP0001"))
                .andExpect(status().is2xxSuccessful());
    }
}
