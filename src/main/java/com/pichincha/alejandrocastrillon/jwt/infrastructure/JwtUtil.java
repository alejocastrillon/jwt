package com.pichincha.alejandrocastrillon.jwt.infrastructure;

import java.util.Date;

import io.jsonwebtoken.Jwts;

public final class JwtUtil {

    private JwtUtil() {
    }
    
    private static final String SECRET = "secret";

    private static final long EXPIRATION_TIME = 864_000_000;

    public static String generateToken(String username) {
        return Jwts.builder()
            .subject(username)
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .compact();
    }
}