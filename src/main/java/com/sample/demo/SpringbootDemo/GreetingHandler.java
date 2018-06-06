package com.sample.demo.SpringbootDemo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject("Hello, Spring!"));
    }

    //immutable
    public Mono<ServerResponse> helloWithName(ServerRequest serverRequest) {
        String name = serverRequest.queryParam("name").get();
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject("Hello "+ name + ", Welcome to Spring!"));
    }
}

