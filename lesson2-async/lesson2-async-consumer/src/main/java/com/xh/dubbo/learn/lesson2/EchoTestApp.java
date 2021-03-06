package com.xh.dubbo.learn.lesson2;


import com.xh.dubbo.learn.lesson2.service.ClientService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@SpringBootApplication
@ImportResource("classpath:/consumer.xml")
public class EchoTestApp {
    @Autowired
    private ClientService clientService;

    @GetMapping("/hi/{name}")
    public String hello(@PathVariable(name = "name") String name) throws InterruptedException, ExecutionException, TimeoutException {
        return clientService.echo(name);

    }

    public static void main(String[] args) {
        System.getProperties().put("server.port", 7070);
        SpringApplication.run(EchoTestApp.class, args);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "consumer")
    @PropertySource("classpath:/dubbo-consumer.properties")
    static public class ConsumerConfiguration {

    }
}
