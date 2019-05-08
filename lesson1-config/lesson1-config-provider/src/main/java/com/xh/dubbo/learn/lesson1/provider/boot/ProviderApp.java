package com.xh.dubbo.learn.lesson1.provider.boot;


import org.apache.dubbo.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
public class ProviderApp {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProviderApp.class, args);
    }
}
