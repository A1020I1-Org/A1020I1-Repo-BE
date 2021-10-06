package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statistical")
public class StatisticalController {

    @Autowired


    @GetMapping(value="/view-by-computer")
    public ResponseEntity<String> viewByComputer(@RequestParam(value = "startTime")String startTime,
                                 @RequestParam(value="endTime")String endTime){
        String dataJson = "";
        if (dataJson == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dataJson, HttpStatus.OK);
    }

    @GetMapping(value = "/view-by-month")
    public ResponseEntity<String> viewByMonth(@RequestParam(value = "startTime")String startTime,
                                              @RequestParam(value="endTime")String endTime){
        return null;
    }

    @GetMapping(value = "/view-by-account")
    public ResponseEntity<String> viewAccount(@RequestParam(value = "startTime", required = false)String startTime,
                                              @RequestParam(value="endTime", required = false)String endTime,
                                              @RequestParam(value="quarter")String quarter){
        return null;
    }

}
