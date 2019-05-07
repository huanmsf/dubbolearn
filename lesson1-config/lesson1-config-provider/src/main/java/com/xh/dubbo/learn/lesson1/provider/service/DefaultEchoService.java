package com.xh.dubbo.learn.lesson1.provider.service;

import com.xh.dubbo.learn.lesson1.api.IEchoService;
import org.apache.dubbo.config.annotation.Service;

@Service(timeout = 5000)
public class DefaultEchoService implements IEchoService {
    public void echo() {
        System.out.printf("hello");
    }
}
