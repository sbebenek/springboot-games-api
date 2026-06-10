/**
 * This class generates a JWT for loggen in session handling
 */
package com.example.games.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    
    //FIXME: put a different key in a .gitignore env later or in application.properties
    private static final String SECRET = "G4jQ2RMlvoTeo2Bt1CZNESoF18EwB4loNX6ajuEOY2x";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(
            SECRET.getBytes(StandardCharsets.UTF_8)
        );
    }

    /**
     * Generates a JWT for a given email address
     * @param email The email address the JWT will be generated for
     * @return A JWT encryption string
     */
    public String generateToken(String email)
    {
        return Jwts.builder()
            .subject(email)
            .issuedAt(new Date())
            .expiration(
                new Date(System.currentTimeMillis()+  1000 * 60 * 60 * 24)) // TODO: get a proper expiration, this one is just 24hrs
            .signWith(getSigningKey())
            .compact();
    }

    /**
     * Extracts the email address from a given JWT - basically a session key
     * @param token the JWT token to be converted to an email address
     * @return  The email for this JWT
     */
    public String extractUsername(String token)
    {
        return Jwts.parser()
            .verifyWith((SecretKey)getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
}
