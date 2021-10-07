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
public class ComputerController_listComputer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ComputerController computerController;

    @Test
    public void testGetListComputer_5() throws Exception {
        ResponseEntity<Page<Computer>> responseEntity
                = this.computerController.listComputer(PageRequest.of(0, 2));
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void testGetListComputer_6(){
        ResponseEntity<Page<Computer>> responseEntity
                = this.computerController.listComputer(PageRequest.of(0,3));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("CP0001",
                responseEntity.getBody().getContent().get(0).getComputerId());
    }
}
