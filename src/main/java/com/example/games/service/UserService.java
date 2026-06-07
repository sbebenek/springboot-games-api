/**
 * A service class processes data in between the route and the model and gets it business ready 
 * https://camunda.com/blog/2025/05/how-to-build-a-rest-api-with-spring-boot-a-step-by-step-guide/
 */
package com.example.games.service;

import com.example.games.model.User;
import com.example.games.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //private List<User> users = new ArrayList<>();

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    // Add
    public User addUser(User user)
    {
        //a user would be new User(email) - will probably need to add a password field later
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findById(id);
    }

    // Update
    public User updateUser(Long id, User userDetails)
    {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
}
