package com.pichincha.alejandrocastrillon.jwt.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmConfig;
import reactor.core.publisher.Mono;

@Component
public final class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private JwtUtil() {
    }

    private static final long EXPIRATION_TIME = 864_000_000;

    public Mono<String> generateToken(String username) {
        return Mono.just(Jwts.builder()
            .subject(username)
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact());
    }
}