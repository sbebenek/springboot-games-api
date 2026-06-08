package com.example.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.games.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //example of added repository query - this is not in the default CRUD stuff that comes with JpaRepository so we had to add it
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.game") 
    List<Product> findAllWithGame();
}
