package com.example.games.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //annotation that says this controller will be returning an object, not a view
public class WelcomeController {
    
    @GetMapping("/welcome") //maps a get request to this endpoint
    public String welcome() {
        return "Welcome to my games API";
    }
    

}
