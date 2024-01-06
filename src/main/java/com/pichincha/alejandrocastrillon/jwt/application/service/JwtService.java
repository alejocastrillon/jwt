package com.pichincha.alejandrocastrillon.jwt.application.service;

import org.springframework.stereotype.Service;

import com.pichincha.alejandrocastrillon.jwt.domain.port.in.JwtUseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class JwtService {

    private final JwtUseCase jwtUseCase;
    
    public Mono<String> generateToken(String username) {
        return jwtUseCase.generateToken(username);
    }
}
