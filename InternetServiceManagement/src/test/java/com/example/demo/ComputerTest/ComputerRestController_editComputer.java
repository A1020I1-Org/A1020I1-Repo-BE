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
public class ComputerRestController_editComputer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editComputer_19() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("null");
        computer.setComputerLocation("null");
        computer.setComputerStartUsedDate("null");
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
                        .post("/computer/edit/null")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editComputer_20() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0001");
        computer.setComputerLocation("");
        computer.setComputerStartUsedDate("");
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
                        .post("/computer/edit/null")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editComputer_21() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0001");
        computer.setComputerLocation("1111");
        computer.setComputerStartUsedDate("1111");
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
                        .post("/computer/edit/null")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editComputer_22() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0001");
        computer.setComputerLocation("A001");
        computer.setComputerStartUsedDate("");
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
                        .post("/computer/edit/null")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editComputer_23() throws Exception{
        Computer computer = new Computer();
        computer.setComputerId("CP0001");
        computer.setComputerLocation("A00011");
        computer.setComputerStartUsedDate("");
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
                        .post("/computer/edit/null")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editComputer_24() throws Exception{
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
                        .post("/computer/edit/CP0001")
                        .content(this.objectMapper.writeValueAsString(computer))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
