package com.example.demo.ComputerTest;

import com.example.demo.entity.Computer;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Status;
import com.example.demo.entity.Type;
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
public class ComputerRestController_createComputer {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createComputer_13() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("");
        computer.setComputerLocation("");
        computer.setComputerStartUsedDate("");
        computer.setComputerWarrantyPeriod("");
        computer.setComputerConfiguration("");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        computer.setManufacturer(manufacturer);
        Status status = new Status();
        status.setStatusId(1);
        computer.setStatus(status);
        Type type = new Type();
        type.setTypeId(1);
        computer.setType(type);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/computer/create")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createComputer_14() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId(" ");
        computer.setComputerLocation(" ");
        computer.setComputerStartUsedDate(" ");
        computer.setComputerWarrantyPeriod(" ");
        computer.setComputerConfiguration(" ");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        computer.setManufacturer(manufacturer);
        Status status = new Status();
        status.setStatusId(1);
        computer.setStatus(status);
        Type type = new Type();
        type.setTypeId(1);
        computer.setType(type);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/computer/create")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createComputer_15() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("1111");
        computer.setComputerLocation("AAAA");
        computer.setComputerStartUsedDate("ABCD1234");
        computer.setComputerWarrantyPeriod(" ");
        computer.setComputerConfiguration(" ");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        computer.setManufacturer(manufacturer);
        Status status = new Status();
        status.setStatusId(1);
        computer.setStatus(status);
        Type type = new Type();
        type.setTypeId(1);
        computer.setType(type);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/computer/create")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createComputer_16() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0001");
        computer.setComputerLocation("A0001");
        computer.setComputerStartUsedDate("10/10/2021");
        computer.setComputerWarrantyPeriod("12 tháng");
        computer.setComputerConfiguration("I7 8G Rom");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        manufacturer.setManufacturerName("Dell");
        computer.setManufacturer(manufacturer);
        Status status = new Status();
        status.setStatusId(1);
        computer.setStatus(status);
        Type type = new Type();
        type.setTypeId(1);
        computer.setType(type);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/computer/create")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createComputer_17() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0001");
        computer.setComputerLocation("A0001");
        computer.setComputerStartUsedDate("10/10/2021");
        computer.setComputerWarrantyPeriod("12 tháng");
        computer.setComputerConfiguration("I7 8G Rom");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        manufacturer.setManufacturerName("Dell");
        computer.setManufacturer(manufacturer);
        Status status = new Status();
        status.setStatusId(1);
        computer.setStatus(status);
        Type type = new Type();
        type.setTypeId(1);
        computer.setType(type);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/computer/create")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createComputer_18() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0002");
        computer.setComputerLocation("A0001");
        computer.setComputerStartUsedDate("10/10/2021");
        computer.setComputerWarrantyPeriod("12 tháng");
        computer.setComputerConfiguration("I7 8G Rom");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        manufacturer.setManufacturerName("Dell");
        computer.setManufacturer(manufacturer);
        Status status = new Status();
        status.setStatusId(1);
        computer.setStatus(status);
        Type type = new Type();
        type.setTypeId(1);
        computer.setType(type);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/computer/create")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
