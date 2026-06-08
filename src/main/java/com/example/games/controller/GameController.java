package com.example.games.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.games.model.Game;
import com.example.games.service.GameService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    //NOTE: I am instead moving games selection routes to products, since games are just products that are only games

    // @GetMapping("/games")
    // public List<Game> getAllGames() {
    //     //return gameService.getAllGames();
    //     return gameService.getAllGamesWithConsole();
    // }
    
    
}
