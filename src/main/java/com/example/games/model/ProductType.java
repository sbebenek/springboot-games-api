package com.example.games.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="product_types")
public class ProductType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> products;
    
    //Default constructor 
    public ProductType() 
    {

    }

    //Parameterized constructor 
    public ProductType(String name)
    {
        this.name = name;
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

   

    @Override
    public String toString()
    {
        return "ProductType{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    
}
