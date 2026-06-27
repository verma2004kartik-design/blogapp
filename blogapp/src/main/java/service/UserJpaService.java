package blogapp.service;

import blogapp.entity.UserEntity;
import blogapp.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJpaService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public UserEntity saveUser(UserEntity user) {

        System.out.println("================================");
        System.out.println("Name = " + user.getName());
        System.out.println("Email = " + user.getEmail());
        System.out.println("Password = " + user.getPassword());
        System.out.println("================================");

        return userJpaRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userJpaRepository.findAll();
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userJpaRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userJpaRepository.deleteById(id);
    }
}