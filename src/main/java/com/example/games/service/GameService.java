package com.example.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.games.model.Game;
import com.example.games.repository.GameRepository;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository)
    {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames()
    {
        return gameRepository.findAll();
    }

    public List<Game> getAllGamesWithConsole()
    {
        return gameRepository.findAllWithConsole();
    }
    
}
