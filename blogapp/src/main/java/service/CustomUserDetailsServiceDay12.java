package blogapp.service;

import blogapp.entity.UserEntityDay12;
import blogapp.repository.UserRepositoryDay12;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceDay12
        implements UserDetailsService {

    @Autowired
    private UserRepositoryDay12 repository;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        UserEntityDay12 user =
                repository.findByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(
                                        "User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}