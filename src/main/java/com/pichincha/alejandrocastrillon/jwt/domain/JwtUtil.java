package com.pichincha.alejandrocastrillon.jwt.domain;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

public final class JwtUtil {

    private JwtUtil() {
    }
    
    private static final String SECRET = "secret";

    private static final long EXPIRATION_TIME = 864_000_000;

    public static Mono<String> generateToken(String username) {
        return Mono.just(Jwts.builder()
            .subject(username)
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .compact());
    }
}