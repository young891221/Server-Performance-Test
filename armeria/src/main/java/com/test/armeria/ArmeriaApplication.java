/*
 * Copyright (c) 2018 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.test.armeria;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.util.EventLoopGroups;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * Created by youngjae.havi on 2019-01-21
 */
//@EnableWebFlux
//@RestController
@SpringBootApplication
public class ArmeriaApplication {

    /**
     * only armeria server
     * @param args
     */
    /*public static void main(String[] args) {
        ServerBuilder sb = new ServerBuilder();
        sb.http(8080);

        sb.workerGroup(EventLoopGroups.newEventLoopGroup(16, "armeria-common-worker", true), true);
        sb.service("/", (ctx, res) -> HttpResponse.of("Hello Armeria"));

        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
        future.join();
    }*/

    /**
     * using spring boot
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ArmeriaApplication.class, args);
    }

    /**
     * spring boot + armeria server and connector is armeria service mapping. Not spring controller.
     * @return
     */
    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator() {
        return serverBuilder -> serverBuilder
                .workerGroup(EventLoopGroups.newEventLoopGroup(16), true)
                .service("/", (ctx, res) -> HttpResponse.of("Hello Armeria"));
    }

    /**
     * sprinb webflux + armeria server and connector is spring webflux controller.
     */
    /*@GetMapping
    Mono<String> hello() {
        return Mono.just("Hello Armeria Webflux");
    }*/
}
