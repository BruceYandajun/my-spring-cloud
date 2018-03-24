package com.github.bruce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/gw")
    public String gw() {
        return "gw";
    }
}
