package blogapp.service;

import blogapp.entity.UserEntityDay14;
import blogapp.repository.UserRepositoryDay14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceDay14
        implements UserDetailsService {

    @Autowired
    private UserRepositoryDay14 repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserEntityDay14 user =
                repository.findByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException("User Not Found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}