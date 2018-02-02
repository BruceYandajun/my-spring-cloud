package com.github.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/1/18.
 *
 * @author yandajun.
 */
@SpringBootApplication
@ComponentScan("com.github.bruce")
public class ApplicationClient extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class, args);
    }
}
