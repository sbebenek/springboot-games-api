package com.example.games.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="games")
public class Game {

    //TODO: look up differences between class and interface and whatever the third one is if there is a third one

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="product_id", unique=true)
    @JsonBackReference // TODO: I don't really understand this
    private Product product; //FIXME: I'm not getting the game name because the name is in products - I need to find out how to get the product name if I'm fetching all games

    @ManyToOne
    @JoinColumn(name="console_id")
    @JsonManagedReference
    private Console console;

    //Default constructor 
    public Game() 
    {

    }

    //Parameterized constructor 
    public Game(Product product) 
    {
        this.product = product;
    } 

    // Getters & Setters
    public Long getId()
    {
        return this.id;
    }

    public Product getProduct()
    {
        return this.product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Console getConsole()
    {
        return this.console;
    }

    public void setConsole(Console console)
    {
        this.console = console;
    }

    

    // @Override
    // public String toString()
    // {
    //     return "Game{" +
    //         "id=" + id +
    //         ", title='" + title + '\'' +
    //         ", releaseDate=" + releaseDate +
    //         ", price=" + price +
    //         '}';
    // }

    
}
