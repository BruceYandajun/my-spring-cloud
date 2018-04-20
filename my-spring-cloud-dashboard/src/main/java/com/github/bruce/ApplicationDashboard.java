package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringCloudApplication
@EnableHystrixDashboard
@EnableTurbine
public class ApplicationDashboard {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDashboard.class, args);
    }
}
