package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description
 * <p>
 * </p>
 * DATE 1/19/18.
 *
 * @author yandajun.
 */
@EnableEurekaServer
@SpringBootApplication

public class ApplicationRegister {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRegister.class);
    }

}
