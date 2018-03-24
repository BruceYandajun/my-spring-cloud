package com.github.bruce.controller;

import com.github.bruce.service.impl.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/consumer")
    public String helloConsumer() {
        // 调用服务端的hello-service
        return helloService.helloService();
    }

    @RequestMapping("/consumerAsync")
    public String helloConsumerAsync() throws ExecutionException, InterruptedException {
        // 调用服务端的hello-service
        return helloService.helloServiceAsync().get();
    }
}
