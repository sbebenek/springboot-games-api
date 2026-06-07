package com.example.games.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    //TODO: product type hasMany relationship

    @Column(name="release_date", nullable = true) // apparantly nullable is true by default, I'm just doing it for learning and readability
    private LocalDate releaseDate;
    @Column(nullable = true)
    private BigDecimal price; // Better than Float for prices apparantly

    //Default constructor 
    public Product() 
    {

    }

    //Parameterized constructor 
    public Product(String title, LocalDate releaseDate, BigDecimal price)
    {
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
    } 

    // Getters & Setters
    public Long getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDate getReleaseDate()
    {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getPrice()
    {
        return this.price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Game{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", price=" + price +
            '}';
    }

    
}
