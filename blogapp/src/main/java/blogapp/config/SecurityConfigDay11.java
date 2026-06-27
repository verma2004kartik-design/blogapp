package blogapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfigDay11 {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/day11/posts")
                        .permitAll()

                        .requestMatchers("/day11/posts/admin")
                        .hasRole("ADMIN")

                        .anyRequest()
                        .authenticated())

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager users() {

        UserDetails user =
                User.withUsername("user")
                        .password("{noop}user123")
                        .roles("USER")
                        .build();

        UserDetails admin =
                User.withUsername("admin")
                        .password("{noop}admin123")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(
                user,
                admin);
    }
}