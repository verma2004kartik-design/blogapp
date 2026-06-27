package blogapp.controller;

import blogapp.entity.UserEntityDay12;
import blogapp.service.UserServiceDay12;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

//@RestController
@RequestMapping("/day12/auth")
public class AuthControllerDay12 {

    @Autowired
    private UserServiceDay12 service;

    @PostMapping("/register")
    public UserEntityDay12 register(
            @RequestBody UserEntityDay12 user) {

        return service.register(user);
    }
}