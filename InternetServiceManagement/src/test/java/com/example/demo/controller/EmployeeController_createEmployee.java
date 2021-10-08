package com.example.demo.controller;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PositionDto;
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

//    @Test
//    public void createStudent_13() throws Exception {
//
//            EmployeeDto employeeDto = new EmployeeDto();
//            employeeDto.setEmployeeId("null");
//            employeeDto.setFullName("Nguyen Uyen");
//            employeeDto.setDateOfBirth("09-10-1999");
//            employeeDto.setEmail("uyen@gmail.com");
//            employeeDto.setAddress("nghean");
//            employeeDto.setPhone("12324266");
//            employeeDto.setLevel("3");
//            employeeDto.setStartWorkDate("03-10-2021");
//            employeeDto.setYearOfExp(10);
//            employeeDto.setAvtUrl("aaa");
//            AccountDto accountDto = new AccountDto();
//            accountDto.setUserName("uyen");
//            accountDto.setPassword("123");
//            employeeDto.setAccountDto(accountDto);
//            PositionDto positionDto = new PositionDto();
//            positionDto.setPositionId(2);
//            employeeDto.setPositionDto(positionDto);
//
//            this.mockMvc
//                    .perform(MockMvcRequestBuilders
//                            .post("/employee/createEmployee")
//                            .content(this.objectMapper.writeValueAsString(employeeDto))
//                            .contentType(MediaType.APPLICATION_JSON_VALUE))
//                    .andDo(print())
//                    .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createStudent_14() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("");
//        employeeDto.setFullName("Nguyen Uyen");
//        employeeDto.setDateOfBirth("09-10-1999");
//        employeeDto.setEmail("uyen@gmail.com");
//        employeeDto.setAddress("nghean");
//        employeeDto.setPhone("12324266");
//        employeeDto.setLevel("3");
//        employeeDto.setStartWorkDate("03-10-2021");
//        employeeDto.setYearOfExp(10);
//        employeeDto.setAvtUrl("aaa");
//        AccountDto accountDto = new AccountDto();
//        accountDto.setUserName("uyen");
//        accountDto.setPassword("123");
//        employeeDto.setAccountDto(accountDto);
//        PositionDto positionDto = new PositionDto();
//        positionDto.setPositionId(2);
//        employeeDto.setPositionDto(positionDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/employee/createEmployee")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createStudent_15() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-02020");
//        employeeDto.setFullName("Nguyen Uyen");
//        employeeDto.setDateOfBirth("09-10-1999");
//        employeeDto.setEmail("uyen@gmail.com");
//        employeeDto.setAddress("nghean");
//        employeeDto.setPhone("12324266");
//        employeeDto.setLevel("3");
//        employeeDto.setStartWorkDate("03-10-2021");
//        employeeDto.setYearOfExp(-10);
//        employeeDto.setAvtUrl("aaa");
//        AccountDto accountDto = new AccountDto();
//        accountDto.setUserName("uyen");
//        accountDto.setPassword("123");
//        employeeDto.setAccountDto(accountDto);
//        PositionDto positionDto = new PositionDto();
//        positionDto.setPositionId(2);
//        employeeDto.setPositionDto(positionDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/employee/createEmployee")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_16() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-02020");
//        employeeDto.setFullName("N");
//        employeeDto.setDateOfBirth("09-10-1999");
//        employeeDto.setEmail("uyen@gmail.com");
//        employeeDto.setAddress("nghean");
//        employeeDto.setPhone("12324266");
//        employeeDto.setLevel("3");
//        employeeDto.setStartWorkDate("03-10-2021");
//        employeeDto.setYearOfExp(-10);
//        employeeDto.setAvtUrl("aaa");
//        AccountDto accountDto = new AccountDto();
//        accountDto.setUserName("uyen");
//        accountDto.setPassword("123");
//        employeeDto.setAccountDto(accountDto);
//        PositionDto positionDto = new PositionDto();
//        positionDto.setPositionId(2);
//        employeeDto.setPositionDto(positionDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/employee/createEmployee")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createStudent_17() throws Exception {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-02020");
//        employeeDto.setFullName("Nguyen văn AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        employeeDto.setDateOfBirth("09-10-1999");
//        employeeDto.setEmail("uyen@gmail.com");
//        employeeDto.setAddress("nghean");
//        employeeDto.setPhone("12324266");
//        employeeDto.setLevel("3");
//        employeeDto.setStartWorkDate("03-10-2021");
//        employeeDto.setYearOfExp(-10);
//        employeeDto.setAvtUrl("aaa");
//        AccountDto accountDto = new AccountDto();
//        accountDto.setUserName("uyen");
//        accountDto.setPassword("123");
//        employeeDto.setAccountDto(accountDto);
//        PositionDto positionDto = new PositionDto();
//        positionDto.setPositionId(2);
//        employeeDto.setPositionDto(positionDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/employee/createEmployee")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }


    @Test
    public void createStudent_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId("NV-0055");
        employeeDto.setFullName("Nguyen Uyen");
        employeeDto.setDateOfBirth("09-10-1999");
        employeeDto.setEmail("uyen@gmail.com");
        employeeDto.setAddress("nghean");
        employeeDto.setPhone("12324266");
        employeeDto.setLevel("3");
        employeeDto.setStartWorkDate("03-10-2021");
        employeeDto.setYearOfExp(10);
        employeeDto.setAvtUrl("aaa");
        AccountDto accountDto = new AccountDto();
        accountDto.setUserName("uyen");
        employeeDto.setAccountDto(accountDto);
        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(2);
        employeeDto.setPositionDto(positionDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                .post("/employee/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }
}
