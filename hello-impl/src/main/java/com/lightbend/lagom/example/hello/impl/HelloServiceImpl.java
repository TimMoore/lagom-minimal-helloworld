package com.lightbend.lagom.example.hello.impl;

import akka.NotUsed;
import com.lightbend.lagom.example.hello.api.HelloService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the HelloService.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public ServiceCall<NotUsed, String> hello(String id) {
        return request -> CompletableFuture.completedFuture("Hello, " + id + "!\n");
    }

}
