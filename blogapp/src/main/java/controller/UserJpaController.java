package blogapp.controller;

import blogapp.entity.UserEntity;
import blogapp.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/users")
public class UserJpaController {

    @Autowired
    private UserJpaService userJpaService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userJpaService.saveUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userJpaService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        return userJpaService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<UserEntity> getUserByEmail(@PathVariable String email) {
        return userJpaService.getUserByEmail(email);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userJpaService.deleteUser(id);
        return "User deleted successfully with id: " + id;
    }
}