package com.pfa.controller;

import com.pfa.model.User;
import com.pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable String id) {
        return userRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable String id) {
        return userRepository.findById(Integer.valueOf(id))
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setRole(newUser.getRole());
                    user.setOrganisation(newUser.getOrganisation());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable String id) {
        userRepository.deleteById(Integer.valueOf(id));
        return "User with id " + id + " has been deleted successfully.";
    }
}
