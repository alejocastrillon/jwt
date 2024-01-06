package com.pichincha.alejandrocastrillon.jwt.application.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.test.StepVerifier;

@SpringBootTest
class JwtUseCaseImplTest {

    @Spy
    private JwtUseCaseImpl useCase;

    @Test
    void testGenerateToken() {
        StepVerifier.create(useCase.generateToken("alejo"))
            .assertNext(Assertions::assertNotNull)
            .verifyComplete();
    }
}
