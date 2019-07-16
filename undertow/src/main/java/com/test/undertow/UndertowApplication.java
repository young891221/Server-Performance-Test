package com.test.undertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * Created by youngjae.havi on 2019-01-21
 */
@RestController
@SpringBootApplication
public class UndertowApplication {
    private HttpClient httpClient = HttpClient.newBuilder().executor(Executors.newScheduledThreadPool(4)).build();

    public static void main(String[] args) {
        SpringApplication.run(UndertowApplication.class, args);
    }

    @GetMapping
    String hello() {
        return "Hello Undertow";
    }

    @GetMapping(value = "/test")
    public CompletableFuture<String> getUserUsingWithCFAndJavaClient() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8083/delay"))
                .GET()
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(x -> "completable-future-java-client: " + x);
    }
}
