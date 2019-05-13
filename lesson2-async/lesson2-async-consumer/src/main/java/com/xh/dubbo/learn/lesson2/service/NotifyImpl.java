package com.xh.dubbo.learn.lesson2.service;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @auther xh
 * @date 5/13/19 3:04 PM
 */
@Component("notify")
public class NotifyImpl implements INotify {
    public void onReturn(String returnStr, String arg) {
        System.out.println("do something onReturn");
        System.out.println(returnStr);
        System.out.println(arg);

    }

    public void onThrow(Throwable ex, String arg) {
        System.out.println("do something onThrow");
        System.out.println(ex.getMessage());
        System.out.println(arg);

    }
}
