package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringCloudApplication
@EnableHystrixDashboard
public class ApplicationDashboard {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDashboard.class, args);
    }
}
