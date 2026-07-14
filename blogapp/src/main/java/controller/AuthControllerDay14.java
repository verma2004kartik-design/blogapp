package blogapp.controller;

import blogapp.dto.AuthResponseDay14;
import blogapp.dto.LoginRequestDay14;
import blogapp.util.JwtUtilDay14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day14/auth")
public class AuthControllerDay14 {

    @Autowired
    private JwtUtilDay14 jwtUtil;

    // LOGIN (TEMPORARY DEBUG VERSION)
    @PostMapping("/login")
    public AuthResponseDay14 login(
            @RequestBody LoginRequestDay14 request) {

        String token = jwtUtil.generateToken(
                request.getUsername());

        return new AuthResponseDay14(token);
    }

    // CURRENT USER
    @GetMapping("/me")
    public String currentUser(
            Authentication authentication) {

        UserDetails user =
                (UserDetails) authentication.getPrincipal();

        return "Logged in User : " + user.getUsername();
    }
}