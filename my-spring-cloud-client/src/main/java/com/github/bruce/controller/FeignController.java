package com.github.bruce.controller;

import com.github.bruce.rpc.BookFeign;
import com.github.bruce.rpc.User;
import com.github.bruce.rpc.UserFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("feign")
public class FeignController {

    @Resource
    private UserFeign userFeign;

    @Resource
    private BookFeign bookFeign;

    @RequestMapping("/getUserName")
    public Object getUserName(Integer id) {
        return userFeign.getUserName(id);
    }

    @GetMapping("/getUserId")
    public Object getUserId(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        return userFeign.getUserId(id, name);
    }

    @RequestMapping("/updateUser")
    public Object updateUser(User user) {
        return userFeign.updateUser(user.getId(), user.getName());
    }

    @RequestMapping("/updateUserJson")
    public Object updateUserJson(@RequestBody User user) {
        return userFeign.updateUserJson(user);
    }

    @RequestMapping("/getBookName")
    public Object getBookName() {
        return bookFeign.getBookName();
    }

    @RequestMapping("/getBookId")
    public Object getBookId() {
        return bookFeign.getBookId();
    }
}
