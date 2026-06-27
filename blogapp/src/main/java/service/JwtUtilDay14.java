package blogapp.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtilDay14 {

    private final String SECRET =
            "mysecretkeymysecretkeymysecretkey123456";

    private final long EXPIRATION =
            1000 * 60 * 60 * 24;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                SECRET.getBytes());
    }

    // Generate JWT Token
    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION))
                .signWith(getSigningKey())
                .compact();
    }

    // Extract Username
    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // Check Expiration
    public boolean isTokenExpired(String token) {

        Date expiry =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload()
                        .getExpiration();

        return expiry.before(new Date());
    }

    // Validate Token
    public boolean validateToken(
            String token,
            String username) {

        return username.equals(
                extractUsername(token))
                && !isTokenExpired(token);
    }
}