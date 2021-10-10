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
public class EmployeeController_createEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createStudent_13() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("null");
        accountEmployee.setFullName("Nguyen");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0901630920");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc11122");
        accountEmployee.setPassword("abc11122");

            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/employee/createEmployee")
                            .content(this.objectMapper.writeValueAsString(accountEmployee))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
    @Test
    public void createStudent_14() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("null");
        accountEmployee.setFullName("Nguyen");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0901630920");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc111223");
        accountEmployee.setPassword("abc111223");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/createEmployee")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createStudent_15() throws Exception {


        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-9999");
        accountEmployee.setFullName("Nguyen Văn A A A A A A A A A A a a a a a a");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0901630920");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc111224");
        accountEmployee.setPassword("abc111224");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/createEmployee")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStudent_16() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("VN-9998");
        accountEmployee.setFullName("N");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0901630920");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc11122");
        accountEmployee.setPassword("abc11122");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/createEmployee")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createStudent_17() throws Exception {

        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("MM-9991");
        accountEmployee.setFullName("Nguyen van a");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0916309250");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abc12359");
        accountEmployee.setPassword("abc12346");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/createEmployee")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createStudent_18() throws Exception {
        AccountEmployee accountEmployee = new AccountEmployee();
        accountEmployee.setEmployeeId("NV-0096");
        accountEmployee.setFullName("Nguyen");
        accountEmployee.setDateOfBirth("11-06-1999");
        accountEmployee.setEmail("abc@gmail.com");
        accountEmployee.setAddress("da nang");
        accountEmployee.setPhone("0901630920");
        accountEmployee.setLevel("test");
        accountEmployee.setStartWorkDate("10-09-2021");
        accountEmployee.setYearOfExp(5);
        accountEmployee.setAvtUrl("abc");
        accountEmployee.setIdPosition(1);
        accountEmployee.setUserName("abd11122");
        accountEmployee.setPassword("abd11122");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                .post("/employee/createEmployee")
                        .content(this.objectMapper.writeValueAsString(accountEmployee))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }
}
