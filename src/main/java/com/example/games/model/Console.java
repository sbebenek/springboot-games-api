package com.example.games.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name="consoles")
public class Console {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "console", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Game> games;

    private String name;
    @Column(name="release_date") 
    private LocalDate releaseDate;

    //Default constructor 
    public Console() 
    {

    }

    //Parameterized constructor 
    public Console(String name, LocalDate releaseDate)
    {
        this.name = name;
        this.releaseDate = releaseDate;
    } 

    // Getters & Setters
    public Long getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getReleaseDate()
    {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    //FIXME: something about this getter breaks the game fetching because getting the games gets the consoles, which gets the games,
    //  which gets the consoles, and so on - need to find out how to break recursion

    // public List<Game> getGames()
    // {
    //     return this.games;
    // }


    

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
