package com.example.demo.controller;

import com.example.demo.entity.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerController_searchComputer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ComputerController computerController;
    @Test
    public void searchComputer_3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/computer/searchComputer/","null"))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchComputer_4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/computer/searchComputer/"," "))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchComputer_5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/computer/searchComputer/","CP0002"))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchComputer_6() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/computer/searchComputer")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchComputer_7() {
        ResponseEntity<Page<Computer>> responseEntity
                = this.computerController.searchComputer("CP0002","A0002","2020/12/13","2020/12/17","","",PageRequest.of(0,3));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalElements());

    }
}
