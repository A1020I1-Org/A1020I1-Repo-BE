package com.example.demo.service;

import com.example.demo.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    Page<Game> findAll(Pageable pageable);
    void deleteGame(String id);
    Game findById(String id);
}
