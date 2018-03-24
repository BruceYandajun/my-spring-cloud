package com.github.bruce.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    private RestTemplate restTemplate;

    private String helloServiceUrl = "http://hello-service/hello";

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity(helloServiceUrl, String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time: " + (end - start) + " ms");
        return result;
    }

    /**
     * 异步调用service
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public Future<String> helloServiceAsync() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity(helloServiceUrl, String.class).getBody();
            }
        };
    }

    private String helloFallback() {
        logger.error("error");
        return "error";
    }

}
