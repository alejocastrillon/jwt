package com.pichincha.alejandrocastrillon.jwt.infrastructure;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
    
    public String generateToken(String username) {
        return JwtUtil.generateToken(username);
    }
}
