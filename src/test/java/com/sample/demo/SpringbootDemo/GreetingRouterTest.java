package com.sample.demo.SpringbootDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void  testHello() {
        webTestClient.get().uri("/hello").accept(MediaType.TEXT_PLAIN).exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Spring!");
    }

    @Test
    public void testHelloWithName() {
        webTestClient.get().uri("/hello2?name=Sauron").accept(MediaType.TEXT_PLAIN).exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello Sauron, Welcome to Spring!");
    }

}
