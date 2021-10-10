package com.example.demo.controller;
import com.example.demo.entity.AccountEmployee;
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
public class EmployeeController_editEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void updateEmployee_13() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-0099");
        accountEmployee.setFullName("null");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("aaaa");
        accountEmployee.setAddress("nghe an");
        accountEmployee.setPhone("0916309250");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc111");
        accountEmployee.setPassword("abc111");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/updateEmployee/{id}")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEmployee_14() throws Exception {


        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("");
        accountEmployee.setUserName("Nguyen van a");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("avc");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0916309250");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc1235");
        accountEmployee.setPassword("abc12346");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/updateEmployee/{id}")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEmployee_15() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-2121");
        accountEmployee.setUserName("Lê Đức Hòaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0916309250");
        accountEmployee.setLevel("-10");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc1235");
        accountEmployee.setPassword("abc12346");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/updateEmployee/{id}")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_16() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-0098");
        accountEmployee.setUserName("a");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0916309250");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc1235");
        accountEmployee.setPassword("abc12346");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/updateEmployee/{id}")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateEmployee_17() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-0098");
        accountEmployee.setUserName("Nguyen van aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0916309250");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc1235");
        accountEmployee.setPassword("abc12346");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/updateEmployee/{id}")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updateEmployee_18() throws Exception {
        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-0098");
        accountEmployee.setUserName("Nguyen Hoa");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("hoaleduc@gmail.com");
        accountEmployee.setAddress("nghean");
        accountEmployee.setPhone("0901630920");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc1112");
        accountEmployee.setPassword("abc1112");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/updateEmployee/{id}")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }
}
