package blogapp.service;

import blogapp.entity.UserEntityDay14;
import blogapp.repository.UserRepositoryDay14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestDay15 {

    @Mock
    private UserRepositoryDay14 repository;

    @InjectMocks
    private UserServiceDay14 service;

    // Test 1 : Save User
    @Test
    void testSaveUser() {

        UserEntityDay14 user = new UserEntityDay14();

        user.setUsername("kartik");
        user.setEmail("kartik@gmail.com");
        user.setPassword("12345");

        when(repository.save(user))
                .thenReturn(user);

        UserEntityDay14 savedUser =
                service.saveUser(user);

        assertNotNull(savedUser);

        assertEquals(
                "kartik",
                savedUser.getUsername());

        assertEquals(
                "kartik@gmail.com",
                savedUser.getEmail());

        verify(repository,
                times(1))
                .save(user);
    }

    // Test 2 : Get All Users
    @Test
    void testGetAllUsers() {

        UserEntityDay14 user1 =
                new UserEntityDay14();

        user1.setUsername("Kartik");

        UserEntityDay14 user2 =
                new UserEntityDay14();

        user2.setUsername("Rahul");

        List<UserEntityDay14> users =
                Arrays.asList(user1, user2);

        when(repository.findAll())
                .thenReturn(users);

        List<UserEntityDay14> result =
                service.getAllUsers();

        assertEquals(2, result.size());

        verify(repository,
                times(1))
                .findAll();
    }

    // Test 3 : Find User By Username
    @Test
    void testGetUserByUsername() {

        UserEntityDay14 user =
                new UserEntityDay14();

        user.setUsername("kartik");

        when(repository.findByUsername("kartik"))
                .thenReturn(Optional.of(user));

        UserEntityDay14 result =
                service.getUserByUsername("kartik");

        assertNotNull(result);

        assertEquals(
                "kartik",
                result.getUsername());

        verify(repository,
                times(1))
                .findByUsername("kartik");
    }

    // Test 4 : User Not Found
    @Test
    void testUserNotFound() {

        when(repository.findByUsername("Amit"))
                .thenReturn(Optional.empty());

        UserEntityDay14 result =
                service.getUserByUsername("Amit");

        assertNull(result);

        verify(repository,
                times(1))
                .findByUsername("Amit");
    }

    // Test 5 : Verify Save Method Called Once
    @Test
    void testSaveMethodCalledOnce() {

        UserEntityDay14 user =
                new UserEntityDay14();

        when(repository.save(user))
                .thenReturn(user);

        service.saveUser(user);

        verify(repository,
                times(1))
                .save(user);
    }
}