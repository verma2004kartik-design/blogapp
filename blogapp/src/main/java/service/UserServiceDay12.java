package blogapp.service;

import blogapp.entity.UserEntityDay12;
import blogapp.repository.UserRepositoryDay12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDay12 {

    @Autowired
    private UserRepositoryDay12 repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntityDay12 register(
            UserEntityDay12 user) {

        if(repository.existsByEmail(
                user.getEmail())) {

            throw new RuntimeException(
                    "Email already exists");
        }

        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()));

        return repository.save(user);
    }
}