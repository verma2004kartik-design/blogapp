package blogapp.controller;

import blogapp.entity.UserEntityDay14;
import blogapp.service.UserServiceDay14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day14/users")
public class UserControllerDay14 {

    @Autowired
    private UserServiceDay14 service;

    // Register User
    @PostMapping
    public UserEntityDay14 registerUser(
            @RequestBody UserEntityDay14 user) {

        return service.saveUser(user);
    }

    // Get All Users
    @GetMapping
    public List<UserEntityDay14> getAllUsers() {

        return service.getAllUsers();
    }

    // Get User by Username
    @GetMapping("/{username}")
    public UserEntityDay14 getUser(
            @PathVariable String username) {

        return service.getUserByUsername(username);
    }
}