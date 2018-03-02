package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/2/18.
 *
 * @author yandajun.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
    }
}
