package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/1/18.
 *
 * @author yandajun.
 */
@SpringCloudApplication
@EnableFeignClients
public class ApplicationClient extends SpringBootServletInitializer {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class, args);
    }
}
