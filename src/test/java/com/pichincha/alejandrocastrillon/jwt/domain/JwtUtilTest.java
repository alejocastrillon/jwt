package com.pichincha.alejandrocastrillon.jwt.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.alejandrocastrillon.jwt.util.JwtUtil;


@SpringBootTest
class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void testGenerateToken() {
        assertNotNull(jwtUtil.generateToken("1234"));
    }
}
