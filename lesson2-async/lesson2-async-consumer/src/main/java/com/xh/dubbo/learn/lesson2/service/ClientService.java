package com.xh.dubbo.learn.lesson2.service;

import com.xh.dubbo.learn.lesson2.api.IEchoService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*@Service*/
public class ClientService {
    /**
     * xml和注解不能同时定义
     */
    /* @Reference*/
    private IEchoService echoService;

    public String echo(String msg) throws ExecutionException, InterruptedException, TimeoutException {


        String result = echoService.echo(msg);// 这里的返回值为空，请不要使用
        Future<String> future = RpcContext.getContext().getFuture();
        // 业务线程可以开始做其他事情
        System.out.println("start do other thing...");
        //Thread.sleep(100);
        System.out.println("print result:" + result);
        System.out.println("other thing is done");

        result = future.get(3000, TimeUnit.MILLISECONDS); // 阻塞需要获取异步结果时，也可以使用 get(timeout, unit) 设置超时时间
        return result == null ? "error result" : result;
    }

    public IEchoService getEchoService() {
        return echoService;
    }

    public void setEchoService(IEchoService echoService) {
        this.echoService = echoService;
    }
}