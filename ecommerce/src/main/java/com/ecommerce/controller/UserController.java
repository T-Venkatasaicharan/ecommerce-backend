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
    public String loginUser(@RequestBody User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return "Username or Password is missing";
        }

        Optional<User> dbUser = userRepository.findByUsername(user.getUsername());

        if (dbUser.isPresent()) {
            if (dbUser.get().getPassword().equals(user.getPassword())) {
                return "Login Successful";
            } else {
                return "Invalid Password";
            }
        } else {
            return "User Not Found";
        }
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}