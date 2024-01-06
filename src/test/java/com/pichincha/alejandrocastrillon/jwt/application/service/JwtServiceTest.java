package com.pichincha.alejandrocastrillon.jwt.application.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.alejandrocastrillon.jwt.domain.port.in.JwtUseCase;
import com.pichincha.alejandrocastrillon.jwt.util.UtilData;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class JwtServiceTest {

    @Mock
    private JwtUseCase jwtUseCase;

    @InjectMocks
    private JwtService service;

    @Test
    void testGenerateToken() {
        when(jwtUseCase.generateToken(anyString())).thenReturn(Mono.just(UtilData.TOKEN));
        StepVerifier.create(service.generateToken("alejo")).assertNext(Assertions::assertNotNull).verifyComplete();
    }
}
