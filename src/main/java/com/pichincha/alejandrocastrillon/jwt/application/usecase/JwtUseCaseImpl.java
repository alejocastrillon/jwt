package com.pichincha.alejandrocastrillon.jwt.application.usecase;

import org.springframework.stereotype.Component;

import com.pichincha.alejandrocastrillon.jwt.domain.JwtUtil;
import com.pichincha.alejandrocastrillon.jwt.domain.port.in.JwtUseCase;

import reactor.core.publisher.Mono;

@Component
public class JwtUseCaseImpl implements JwtUseCase {

    @Override
    public Mono<String> generateToken(String username) {
        return JwtUtil.generateToken(username);
    }
    
}
