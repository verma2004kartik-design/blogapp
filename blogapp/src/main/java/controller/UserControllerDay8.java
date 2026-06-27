package blogapp.controller;

import blogapp.dto.UserRegistrationDTO;
import blogapp.entity.UserEntityDay8;
import blogapp.service.UserServiceDay8;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day8/users")
public class UserControllerDay8 {

    @Autowired
    private UserServiceDay8 service;

    // Create User
    @PostMapping
    public UserEntityDay8 createUser(
            @Valid
            @RequestBody UserEntityDay8 user) {

        return service.saveUser(user);
    }

    // DTO Registration Validation
    @PostMapping("/register")
    public String registerUser(
            @Valid
            @RequestBody UserRegistrationDTO user) {

        return "Registration Successful";
    }
}