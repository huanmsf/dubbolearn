package com.xh.dubbo.learn.lesson1.provider.boot;


import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@DubboComponentScan(basePackages = "com.xh.dubbo.learn.lesson1.provider.service")
public class ProviderApp {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }
}
