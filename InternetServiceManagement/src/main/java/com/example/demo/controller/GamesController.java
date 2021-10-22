package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.service.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GamesController {
    @Autowired
    GameServiceImpl gameService;

    @GetMapping(value = {"/", "/list"})
    public ResponseEntity<Page<Game>> findAllGame(@PageableDefault(size = 2) Pageable pageable){
        Page<Game> listGame = this.gameService.findAll(pageable);
        if (listGame.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listGame, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Game>deleteGame(@PathVariable String id){
        Game gameId = this.gameService.findById(id);
        System.out.println("a "+gameId);
        if (gameId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
