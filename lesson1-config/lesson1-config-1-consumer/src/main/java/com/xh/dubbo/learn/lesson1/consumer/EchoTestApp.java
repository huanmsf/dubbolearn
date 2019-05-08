package com.xh.dubbo.learn.lesson1.consumer;

import com.xh.dubbo.learn.lesson1.consumer.service.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EchoTestApp {

    @Autowired
    private ClientService clientService;

    @GetMapping("/hi/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return clientService.echo(name);

    }

    public static void main(String[] args) {
        System.getProperties().put( "server.port", 7070 );
        SpringApplication.run(EchoTestApp.class, args);
    }


}
