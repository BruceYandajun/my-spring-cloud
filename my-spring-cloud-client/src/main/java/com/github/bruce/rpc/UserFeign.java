package com.github.bruce.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user", url = "${user.host}", fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign {

    @GetMapping(name = "getUserName", path = "/getUserName")
    String getUserName();

    @GetMapping(name = "getUserId", path = "/getUserId")
    Integer getUserId();
}
