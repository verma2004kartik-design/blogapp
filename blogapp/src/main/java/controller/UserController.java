package blogapp.controller;

import blogapp.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private long idCounter = 1;   // for manual ID generation

    // ---------------- CREATE USER ----------------
    @PostMapping
    public String createUser(@RequestBody User user) {

        if (!user.getEmail().contains("@")) {
            return "Invalid Email!";
        }

        user.setId(idCounter++);   // assign ID
        users.add(user);

        return "User Added Successfully";
    }

    // ---------------- GET ALL USERS ----------------
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // ---------------- GET USER BY ID ----------------
    @GetMapping("/{id}")
    public Object getUserById(@PathVariable Long id) {

        for (User user : users) {
            if (user.getId() != null && user.getId().equals(id)) {
                return user;
            }
        }

        return "User not found";
    }

    // ---------------- UPDATE USER ----------------
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.getId() != null && user.getId().equals(id)) {

                if (!updatedUser.getEmail().contains("@")) {
                    return "Invalid Email!";
                }

                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());

                return "User updated successfully";
            }
        }

        return "User not found";
    }

    // ---------------- DELETE USER ----------------
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        for (User user : users) {
            if (user.getId() != null && user.getId().equals(id)) {
                users.remove(user);
                return "User deleted successfully";
            }
        }

        return "User not found";
    }
}