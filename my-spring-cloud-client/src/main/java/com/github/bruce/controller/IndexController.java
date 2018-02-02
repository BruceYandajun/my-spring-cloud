package com.github.bruce.controller;

import com.github.bruce.service.IMyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/1/18.
 *
 * @author yandajun.
 */
@RestController
public class IndexController {

    @Resource
    private IMyService myService;

    @RequestMapping("/")
    public String welcome(){
        return "Welcome to my-spring-cloud-client !";
    }

    @RequestMapping("/go")
    public String go() {
       return myService.go();
    }
}
