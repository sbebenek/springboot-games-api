package com.example.games.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.games.model.User;
import com.example.games.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {

    private final AuthenticationService authService;

    public AuthController(
            AuthenticationService authService) {
        this.authService = authService;
    }

    /**
     * Registration route that accepts a user object with email and password fields, creates that user, and returns a JWT if valid
     * @param user
     * @return a JWT token
     */
    @PostMapping("/register")
     public String register(@RequestBody User user) {
        return authService.register(
                user.getEmail(),
                user.getPassword()
        );
    }

    /**
     * Login route that accepts a user object with email and password fields and returns a JWT if valid
     * @param user
     * @return a JWT token
     */
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.login(
                user.getEmail(),
                user.getPassword()
        );
    }

    //TODO: logout
    //TODO: how to do authentication middleware on routes
}
