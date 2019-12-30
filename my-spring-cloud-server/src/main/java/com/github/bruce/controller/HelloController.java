package com.github.bruce.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/2/18.
 *
 * @author yandajun.
 */
@RestController
public class HelloController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String index(String name) throws InterruptedException {
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(System.out::println);
        List<ServiceInstance> instances = discoveryClient.getInstances("hello-service");
        instances.stream().forEach(instance ->
            System.out.println(instance.getHost() + ":" + instance.getPort() + "->" + instance.getUri())
        );
        System.out.println("parameter name:" + name);
        Thread.sleep(new Random().nextInt(3000));
        return "hello-world";
    }

    @RequestMapping("/feign")
    public String feign(@RequestParam String name) {
        return name;
    }
}
