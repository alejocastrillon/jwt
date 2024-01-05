package com.pichincha.alejandrocastrillon.jwt.application.rest;

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

import com.pichincha.alejandrocastrillon.jwt.infrastructure.JwtService;

@WebFluxTest(controllers = JwtController.class)
class JwtControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private JwtService service;

    private static final String TOKEN = "eyJhbGciOiJub25lIn0.eyJzdWIiOiJhbGVqbyIsImV4cCI6MTcwNTM0MjIyN30.";

    @Test
    void givenValidRequestInfoWhenGenerateTokenThenReturnToken() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username", "alejo");
        params.add("password", "123456");
        when(service.generateToken(anyString())).thenReturn(TOKEN);
        client.post().uri("/v1/jwt").contentType(MediaType.MULTIPART_FORM_DATA)
            .header(HttpHeaders.CONTENT_DISPOSITION, "form-data;")
            .body(BodyInserters.fromMultipartData(params)).exchange().expectStatus().isOk();
    }
}
