package blogapp.controller;

import blogapp.dto.CreateUserRequestDay10;
import blogapp.dto.UserDTODay10;
import blogapp.service.UserServiceDay10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day10/users")
public class UserControllerDay10 {

    @Autowired
    private UserServiceDay10 service;

    // Create User
    @PostMapping
    public UserDTODay10 createUser(
            @RequestBody
            CreateUserRequestDay10 request) {

        return service.createUser(request);
    }

    // Get User By Id
    @GetMapping("/{id}")
    public UserDTODay10 getUser(
            @PathVariable Long id) {

        return service.getUserById(id);
    }

    // Get All Users
    @GetMapping
    public List<UserDTODay10> getAllUsers() {

        return service.getAllUsers();
    }
}