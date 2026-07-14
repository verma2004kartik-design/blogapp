package blogapp.service;

import blogapp.entity.UserEntityDay14;
import blogapp.repository.UserRepositoryDay14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDay14 {

    @Autowired
    private UserRepositoryDay14 repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register User
    public UserEntityDay14 saveUser(UserEntityDay14 user) {

        // Check duplicate email
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    // Get All Users
    public List<UserEntityDay14> getAllUsers() {
        return repository.findAll();
    }

    // Get User by Username
    public UserEntityDay14 getUserByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}