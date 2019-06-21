package com.github.bruce.controller;

import com.github.bruce.rpc.BookFeign;
import com.github.bruce.rpc.UserFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("feign")
public class FeignController {

    @Resource
    private UserFeign userFeign;

    @Resource
    private BookFeign bookFeign;

    @RequestMapping("/getUserName")
    public Object getUserName() {
        return userFeign.getUserName();
    }

    @RequestMapping("/getUserId")
    public Object getUserId() {
        return userFeign.getUserId();
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
