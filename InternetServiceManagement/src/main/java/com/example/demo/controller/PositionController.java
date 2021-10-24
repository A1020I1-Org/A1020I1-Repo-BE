package com.example.demo.controller;

import com.example.demo.entity.Position;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/position")
@CrossOrigin("http://localhost:4200/")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping(value = "/listPosition", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Position>> getPositionList() {
        List<Position> positionList = positionService.getAllPosition();
        if(positionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }
}
