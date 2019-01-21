/*
 * Copyright (c) 2018 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.test.vertx;


import io.vertx.core.AbstractVerticle;

/**
 * Created by youngjae.havi on 2019-01-21
 */
public class VertxApplication extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> req
                .response()
                .putHeader("content-type", "text/plain")
                .end("HelloWorld vert.x"))
                .listen(8080);
    }
}
