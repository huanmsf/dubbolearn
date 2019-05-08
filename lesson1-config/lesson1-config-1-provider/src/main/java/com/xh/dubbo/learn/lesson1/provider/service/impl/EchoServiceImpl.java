package com.xh.dubbo.learn.lesson1.provider.service.impl;

import com.xh.dubbo.learn.lesson1.api.IEchoService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class EchoServiceImpl implements IEchoService {
    public void echo() {
        System.out.printf("hello");
    }

    public String echo(String msg) {
        return "echo: " + msg;
    }
}
