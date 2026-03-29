package com.ecommerce.controller;
import java.util.List;
import java.util.Optional;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());

        if (dbUser == null) {
            return "User not found ❌";
        }

        if (dbUser.getPassword().equals(user.getPassword())) {
            return "Login successful ✅";
        } else {
            return "Wrong password ❌";
        }
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}