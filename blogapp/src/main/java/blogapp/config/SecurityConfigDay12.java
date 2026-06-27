package blogapp.config;

import blogapp.service.CustomUserDetailsServiceDay12;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;

import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfigDay12 {

    @Autowired
    private CustomUserDetailsServiceDay12 service;

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/day12/auth/register")
                        .permitAll()

                        .anyRequest()
                        .authenticated())

                .userDetailsService(service)

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}