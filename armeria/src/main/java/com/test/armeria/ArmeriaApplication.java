/*
 * Copyright (c) 2018 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.test.armeria;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.util.EventLoopGroups;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Created by youngjae.havi on 2019-01-21
 */
public class ArmeriaApplication {
    public static void main(String[] args) {
        ServerBuilder sb = new ServerBuilder();
        sb.http(8080);

        sb.workerGroup(EventLoopGroups.newEventLoopGroup(16, "armeria-common-worker", true), true);
        sb.service("/", (ctx, res) -> HttpResponse.of("Hello Armeria"));

        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
        future.join();
    }
}
