package com.pichincha.alejandrocastrillon.jwt.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JwtUtilTest {

    @Spy
    private JwtUtil jwtUtil;

    @Test
    void testGenerateToken() {
        assertNotNull(jwtUtil.generateToken("1234"));
    }
}
