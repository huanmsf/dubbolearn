package com.xh.dubbo.learn.lesson1.consumer;

import com.xh.dubbo.learn.lesson1.consumer.service.ClientService;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EchoTestApp {

    @Autowired
    private ClientService clientService;

    @GetMapping("/hi")
    public String hello() {
        clientService.echo();
        return "hi";
    }

    public static void main(String[] args) {
        System.getProperties().put( "server.port", 7070 );
        SpringApplication.run(EchoTestApp.class, args);
    }


}
