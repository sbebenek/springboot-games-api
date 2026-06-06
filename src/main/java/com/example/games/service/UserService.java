/**
 * A service class processes data in between the route and the model and gets it business ready 
 */
package com.example.games.service;

import com.example.games.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers()
    {
        return users;
    }
}
