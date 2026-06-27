package blogapp.service;

import blogapp.dto.CreateUserRequestDay10;
import blogapp.dto.UserDTODay10;
import blogapp.entity.UserEntityDay10;
import blogapp.mapper.MapperUtilDay10;
import blogapp.repository.UserRepositoryDay10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceDay10 {

    @Autowired
    private UserRepositoryDay10 repository;

    // Create User
    public UserDTODay10 createUser(
            CreateUserRequestDay10 request) {

        UserEntityDay10 user =
                new UserEntityDay10();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        UserEntityDay10 savedUser =
                repository.save(user);

        return MapperUtilDay10.toDTO(savedUser);
    }

    // Get User By Id
    public UserDTODay10 getUserById(Long id) {

        UserEntityDay10 user =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User Not Found"));

        return MapperUtilDay10.toDTO(user);
    }

    // Get All Users
    public List<UserDTODay10> getAllUsers() {

        return repository.findAll()
                .stream()
                .map(MapperUtilDay10::toDTO)
                .collect(Collectors.toList());
    }
}