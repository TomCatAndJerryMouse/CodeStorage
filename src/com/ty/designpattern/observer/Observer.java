package com.ty.designpattern.observer;
/**
 * 观察者
 * @author Administrator
 *
 */
public interface Observer
{
    /**
     * 发送消息
     * @return
     */
    public void message(String str);
}
