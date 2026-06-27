package blogapp.controller;

import blogapp.dto.LoginRequestDay13;
import blogapp.util.JwtUtilDay13;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.*;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@RestController
@RequestMapping("/day13/auth")
public class AuthControllerDay13 {

    @Autowired
    private AuthenticationManager
            authenticationManager;

    @Autowired
    private JwtUtilDay13 jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(

            @RequestBody
            LoginRequestDay13 request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()
                )
        );

        String token =
                jwtUtil.generateToken(
                        request.getUsername());

        Map<String, String> response =
                new HashMap<>();

        response.put(
                "token",
                token);

        return response;
    }
}