package com.example.games.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    //Default construnctor
    public User() {
    }

    // Parameterized constructor
    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    //probably shouldnt have a setter for ID

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
