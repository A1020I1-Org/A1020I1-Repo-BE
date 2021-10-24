package com.example.demo.controller;

import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getListEmployee {
    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListEmployee_5() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/listEmployee")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListEmployee_6() {

        ResponseEntity<Page<Employee>> responseEntity
                = this.employeeController.getAllEmployee(PageRequest.of(0, 2));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getEmployeeId());
    }

    @Test
    public void getListEmployee_7() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/searchEmployee","null")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_8() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/searchEmployee","")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_9() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/searchEmployee","123")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_10() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/searchEmployee")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListEmployee_11() {
        ResponseEntity<Page<Employee>> responseEntity
                = this.employeeController.searchEmployee("1","2021-10-07",
                "2021-10-10","2021-10-07","2021-10-10",
                "Nghệ An",1,PageRequest.of(0,2));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
    }
}
