package com.pichincha.alejandrocastrillon.jwt.infrastructure.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

import com.pichincha.alejandrocastrillon.jwt.application.service.JwtService;
import com.pichincha.alejandrocastrillon.jwt.util.UtilData;

import reactor.core.publisher.Mono;

@WebFluxTest(controllers = JwtController.class)
class JwtControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private JwtService service;

    @Test
    void givenValidRequestInfoWhenGenerateTokenThenReturnToken() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "alejo");
        params.add("password", "123456");
        when(service.generateToken(anyString())).thenReturn(Mono.just(UtilData.TOKEN));
        client.post().uri("/v1/jwt").contentType(MediaType.MULTIPART_FORM_DATA)
            .header(HttpHeaders.CONTENT_DISPOSITION, "form-data;")
            .body(BodyInserters.fromMultipartData(params)).exchange().expectStatus().isOk();
    }
}
