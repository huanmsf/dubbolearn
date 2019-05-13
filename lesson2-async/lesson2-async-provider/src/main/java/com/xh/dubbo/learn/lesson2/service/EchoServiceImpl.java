package com.xh.dubbo.learn.lesson2.service;


import com.xh.dubbo.learn.lesson2.api.IEchoService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class EchoServiceImpl implements IEchoService {

    public String echo(String msg) {
        return "echo: " + msg;
    }
}
