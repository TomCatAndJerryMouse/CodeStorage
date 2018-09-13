package com.ty.designpattern.observer;

/**
 * 订阅者
 * 观察者
 * @author Administrator
 *
 */ 
public class Subscriber implements Observer
{
    /**
     *订阅者名字 
     */
    private String username;
    
    public Subscriber(String username)
    {
      this.username = username;
    }
    
    /**
     * 发送比赛消息
     */
    public void message(String str)
    {
        System.out.println(username + "你订阅的比赛 " + str  + " 即将开始！" );
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

}
