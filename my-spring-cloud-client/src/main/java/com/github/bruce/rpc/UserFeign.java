package com.github.bruce.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user", url = "${user.host}", fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign {

    @GetMapping(name = "getUserName", path = "/getUserName")
    String getUserName(@RequestParam("id") Integer id);

    @GetMapping(name = "getUserId", path = "/getUserId")
    Integer getUserId();

    @PostMapping(path="/updateUser")
    Object updateUser(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @PostMapping(path="/updateUserJson")
    Object updateUserJson(@RequestBody User user);
}
