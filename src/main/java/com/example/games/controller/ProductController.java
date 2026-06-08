package com.example.games.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.games.model.Product;
import com.example.games.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/games")
    public List<Product> getAllProductsThatAreGames() {
        return productService.getAllProductsWithGames();
    }

    
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id)
    {
        Product product = productService.getProductById(id)
            .orElseThrow(() -> new RuntimeException("Product not found with id " + id)); //FIXME: gracefully return null instead of throwing an error or something
        return ResponseEntity.ok(product);
    }
    
    
}
