package com.github.bruce.controller;

import com.github.bruce.service.ClientFeignService;
import com.github.bruce.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {

    @Resource
    private HelloService helloService;

    @Resource
    private ClientFeignService feignService;

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

    @GetMapping("/feign")
    public String feign(@RequestParam String name) {
        return feignService.feign(name);
    }
}
