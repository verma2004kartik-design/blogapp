package blogapp.controller;

import blogapp.entity.UserEntityDay5;
import blogapp.service.UserServiceDay5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day5/users")
public class UserControllerDay5 {

    @Autowired
    private UserServiceDay5 userServiceDay5;

    // CREATE USER
    @PostMapping
    public UserEntityDay5 createUser(@RequestBody UserEntityDay5 user) {
        return userServiceDay5.saveUser(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<UserEntityDay5> getAllUsers() {
        return userServiceDay5.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public UserEntityDay5 getUserById(@PathVariable Long id) {
        return userServiceDay5.getUserById(id);
    }
}