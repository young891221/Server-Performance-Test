/*
 * Copyright (c) 2018 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.test.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Created by youngjae.havi on 2019-01-21
 */
@RestController
@EnableWebFlux
@SpringBootApplication
public class WebfluxApplication {
    private final WebClient webClient;

    @Autowired
    public WebfluxApplication() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8083").build();
    }

    public static void main(String[] args) {
        //System.setProperty("reactor.netty.ioWorkerCount", "16");
        SpringApplication.run(WebfluxApplication.class, args);
    }

    @GetMapping
    Mono<String> hello() {
        return Mono.just("Hello Webflux");
    }

    @GetMapping("/test")
    Mono<String> delay() {
        return webClient.get()
                .uri("/delay")
                .retrieve()
                .bodyToMono(String.class)
                .map(x -> "webflux-webclient: " + x);
    }

    @GetMapping("/delay")
    public Mono<String> getUserWithDelay() {
        return Mono.just("delay")
                .delayElement(Duration.ofMillis(3));
    }
}
