package consumer.service.impl;

import com.xh.dubbo.learn.lesson1.api.IEchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Reference
    private IEchoService echoService;

    public String echo(String msg) {
        return echoService.echo(msg);
    }
}