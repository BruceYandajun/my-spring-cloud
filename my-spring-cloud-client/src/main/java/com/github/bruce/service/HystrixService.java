package com.github.bruce.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service
@DefaultProperties
public class HystrixService {
    private int total = 0;
    private int fallback = 0;

    @HystrixCommand(fallbackMethod = "getUserFallBack", groupKey = "user", threadPoolKey = "user",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "1000")
    },
    threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maximumSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "5")
    })
    public String getUser(Integer userId) {
        total ++;
        System.out.println("total : " + total);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        throw new NullPointerException();
        return "user" + new Random().nextInt();
    }

    private String getUserFallBack(Integer userId) {
        fallback ++;
        System.out.println("fallback : " + fallback);
        return "getUserFallBack";
    }

    @HystrixCommand(fallbackMethod = "defaultUser")
    public Future<String> getUserByIdAsync() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                int a = 1 / 0 ;
                return "user";
            }
        };
    }

    private String defaultUser() {
        fallback ++;
        System.out.println("fallback : " + fallback);
        return "defaultUser";
    }

//    @TestAspect
    public String test() {
        return "test";
    }

}
