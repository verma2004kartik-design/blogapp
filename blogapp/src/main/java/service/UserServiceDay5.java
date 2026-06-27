package blogapp.service;

import blogapp.entity.UserEntityDay5;
import blogapp.repository.UserRepositoryDay5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDay5 {

    @Autowired
    private UserRepositoryDay5 userRepositoryDay5;

    public UserEntityDay5 saveUser(UserEntityDay5 user) {
        return userRepositoryDay5.save(user);
    }

    public List<UserEntityDay5> getAllUsers() {
        return userRepositoryDay5.findAll();
    }

    public UserEntityDay5 getUserById(Long id) {
        return userRepositoryDay5.findById(id).orElse(null);
    }
}