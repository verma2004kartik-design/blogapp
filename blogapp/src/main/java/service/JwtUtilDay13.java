package blogapp.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtilDay13 {

    private final String SECRET =
            "mysecretkeymysecretkeymysecretkey123456";

    private final long EXPIRATION =
            1000 * 60 * 60 * 24;

    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                SECRET.getBytes());
    }

    public String generateToken(
            String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION))
                .signWith(
                        getSigningKey())
                .compact();
    }

    public String extractUsername(
            String token) {

        return Jwts.parser()
                .verifyWith(
                        (javax.crypto.SecretKey)
                                getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(
            String token,
            String username) {

        return username.equals(
                extractUsername(token));
    }
}