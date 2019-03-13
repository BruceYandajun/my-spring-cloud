package com.github.bruce.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface ClientFeignService {

    @RequestMapping("feign")
    String feign(@RequestParam("name") String name);
}
