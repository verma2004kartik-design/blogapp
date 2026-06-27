package blogapp.service;

import blogapp.entity.UserEntityDay14;
import blogapp.repository.UserRepositoryDay14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDay14 {

    @Autowired
    private UserRepositoryDay14 repository;

    public UserEntityDay14 saveUser(UserEntityDay14 user) {
        return repository.save(user);
    }

    public List<UserEntityDay14> getAllUsers() {
        return repository.findAll();
    }

    public UserEntityDay14 getUserByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}