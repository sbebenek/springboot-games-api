package com.example.games.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name="release_date", nullable = true) // apparantly nullable is true by default, I'm just doing it for learning and readability
    private LocalDate releaseDate;
    @Column(nullable = true)
    private BigDecimal price; // Better than Float for prices apparantly

    //Belongs to ProductType (a product has one product type)
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @OneToOne(mappedBy = "product")
    //@JsonIgnore // this will ignore fetching the game with the product, which prevents recursion if I tried to fetch the Games (Game -> Product -> Game -> ...) - but then I can't get the games when I get the product
    @JsonManagedReference 
    private Game game;

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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString()
    {
        return "Product{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", productType='" + productType.getName() + '\'' +
            ", price=" + price +
            '}';
    }

    
}
