package com.example.games.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.games.model.Product;
import com.example.games.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsWithGames()
    {
        // List<Product> products = productRepository.findAllWithGame();
        // for (Product p : products) {
        //     System.out.println("Product: " + p.getTitle());
        //     System.out.println("Game: " + p.getGame());
        // }

        // return products;
        

        return productRepository.findAllWithGame();
    }

    public Optional<Product> getProductById(Long id)
    {
        return productRepository.findById(id);
    }
    
}
