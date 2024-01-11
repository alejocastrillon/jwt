package com.pichincha.alejandrocastrillon.jwt.application.usecase;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.alejandrocastrillon.jwt.domain.JwtUtil;
import com.pichincha.alejandrocastrillon.jwt.util.UtilData;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class JwtUseCaseImplTest {

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private JwtUseCaseImpl useCase;

    @Test
    void testGenerateToken() {
        when(jwtUtil.generateToken(anyString())).thenReturn(Mono.just(UtilData.TOKEN));
        StepVerifier.create(useCase.generateToken("alejo"))
            .assertNext(Assertions::assertNotNull)
            .verifyComplete();
    }
}
