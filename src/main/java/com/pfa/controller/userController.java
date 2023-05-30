package com.pfa.controller;
import com.pfa.exception.userNotFoundException;
import com.pfa.model.user;
import com.pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by Arjun Gautam */
@RestController
@CrossOrigin("http://localhost:3000")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    user newUser(@RequestBody user newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<user> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    user getUserById(@PathVariable Integer id) throws userNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new userNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    user updateUser(@RequestBody user newUser, @PathVariable  Integer id) throws userNotFoundException {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new userNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Integer id) throws userNotFoundException {
        if(!userRepository.existsById(Math.toIntExact(id))){
            throw new userNotFoundException(id);
        }
        userRepository.deleteById(Math.toIntExact(id));
        return  "User with id "+id+" has been deleted success.";
    }



}