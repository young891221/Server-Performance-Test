package com.test.undertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngjae.havi on 2019-01-21
 */
@RestController
@SpringBootApplication
public class UndertowApplication {

    public static void main(String[] args) {
        SpringApplication.run(UndertowApplication.class, args);
    }

    @GetMapping
    String hello() {
        return "Hello Undertow";
    }
}
