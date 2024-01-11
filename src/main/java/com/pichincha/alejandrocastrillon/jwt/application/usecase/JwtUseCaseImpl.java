package com.pichincha.alejandrocastrillon.jwt.application.usecase;

import org.springframework.stereotype.Component;

import com.pichincha.alejandrocastrillon.jwt.domain.JwtUtil;
import com.pichincha.alejandrocastrillon.jwt.domain.port.in.JwtUseCase;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class JwtUseCaseImpl implements JwtUseCase {

    private final JwtUtil jwtUtil;

    @Override
    public Mono<String> generateToken(String username) {
        return jwtUtil.generateToken(username);
    }
    
}
