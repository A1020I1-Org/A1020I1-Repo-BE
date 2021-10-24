package com.example.demo.service.impl;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    GameRepository gameRepository;

    @Override
    public Page<Game> findAll(Pageable pageable) {
        return this.gameRepository.findAll(pageable);
    }

    @Override
    public void deleteGame(String id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public Game findById(String id) {
        return this.gameRepository.findById(id).orElse(null);
    }
}
