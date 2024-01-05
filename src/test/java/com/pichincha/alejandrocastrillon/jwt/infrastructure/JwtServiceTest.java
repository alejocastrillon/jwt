package com.pichincha.alejandrocastrillon.jwt.infrastructure;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService service;

    @Test
    void givenValidUsernameWhenGenerateTokenThenReturnToken() {
        String token = service.generateToken("alejo");
        assertNotNull(token);
    }
}
