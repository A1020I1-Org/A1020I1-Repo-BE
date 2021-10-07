package com.example.demo.controller;

import com.example.demo.entity.DataForComputer;
import com.example.demo.entity.DataForMonth;
import com.example.demo.entity.DataForTopAccount;
import com.example.demo.service.StatisticalService;
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
    private StatisticalService statisticalService;

    @GetMapping(value="/view-by-computer")
    public ResponseEntity<List<DataForComputer>> viewByComputer(@RequestParam(value = "startTime")String startTime,
                                                                @RequestParam(value="endTime")String endTime){
        List<DataForComputer> list = this.statisticalService.findAllInStartTimeToEndTime(startTime, endTime);
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/view-by-month")
    public ResponseEntity<List<DataForMonth>> viewByMonth(@RequestParam(value = "startTime")String startTime,
                                                          @RequestParam(value="endTime")String endTime){
        List<DataForMonth> list = this.statisticalService.getDataByMonth(startTime, endTime);
        if(list == null || list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/view-by-account")
    public ResponseEntity<List<DataForTopAccount>> viewAccount(@RequestParam(value = "startTime", required = false)String startTime,
                                                               @RequestParam(value="endTime", required = false)String endTime,
                                                               @RequestParam(value="quarter")String quarter){
        List<DataForTopAccount> list = this.statisticalService.getDataByAccount(startTime, endTime);
        if(list == null || list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}


