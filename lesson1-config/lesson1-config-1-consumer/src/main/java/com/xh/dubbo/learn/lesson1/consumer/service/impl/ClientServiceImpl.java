package com.xh.dubbo.learn.lesson1.consumer.service.impl;

import com.xh.dubbo.learn.lesson1.api.IEchoService;
import com.xh.dubbo.learn.lesson1.consumer.service.ClientService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Reference
    private IEchoService echoService;

    public void echo() {
        echoService.echo();
    }
}
