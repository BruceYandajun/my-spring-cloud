package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApplicationGW  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationGW.class, args);
    }
}
