package com.example.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.games.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
}
