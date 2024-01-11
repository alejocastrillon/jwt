package com.pichincha.alejandrocastrillon.jwt.infrastructure.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pichincha.alejandrocastrillon.jwt.application.service.JwtService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/v1/jwt")
@AllArgsConstructor
public class JwtController {

    private final JwtService jwtService;
    
    @PostMapping()
    public Mono<String> generateJwt(@RequestPart(name = "username") String username, @RequestPart(name = "password") String password) {
        return jwtService.generateToken(username);
    }
    
}
