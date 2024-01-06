package com.pichincha.alejandrocastrillon.jwt.domain.port.in;

import reactor.core.publisher.Mono;

public interface JwtUseCase {

    Mono<String> generateToken(String username);

}
