package com.xh.dubbo.learn.lesson2.service;

/**
 * TODO
 *
 * @auther xh
 * @date 5/13/19 3:00 PM
 */
public interface INotify {
    void onReturn(String returnStr, String arg);

    void onThrow(Throwable ex, String arg);
}
