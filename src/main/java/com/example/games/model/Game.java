package com.example.games.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="games")
public class Game {

    //FIXME: all these columns are wrong, this is actually the columns for the 'products' table and needs to be fixed
    //TODO: look up differences between class and interface and whatever the third one is if there is a third one

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
    public Game() 
    {

    }

    //Parameterized constructor 
    public Game(String title, LocalDate releaseDate, BigDecimal price)
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
