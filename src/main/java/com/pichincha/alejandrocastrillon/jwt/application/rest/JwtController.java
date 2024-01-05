package com.pichincha.alejandrocastrillon.jwt.application.rest;

import org.springframework.web.bind.annotation.RestController;

import com.pichincha.alejandrocastrillon.jwt.infrastructure.JwtService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/v1/jwt")
@AllArgsConstructor
public class JwtController {

    private final JwtService jwtService;
    
    @PostMapping()
    public String generateJwt(@RequestPart String username, @RequestPart String password) {
        return jwtService.generateToken(username);
    }
    
}
