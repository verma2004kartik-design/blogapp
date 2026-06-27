package blogapp.service;

import blogapp.entity.UserEntityDay8;
import blogapp.repository.UserRepositoryDay8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDay8 {

    @Autowired
    private UserRepositoryDay8 repository;

    public UserEntityDay8 saveUser(
            UserEntityDay8 user) {

        return repository.save(user);
    }
}