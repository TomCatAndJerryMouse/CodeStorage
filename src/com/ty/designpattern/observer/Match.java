package com.ty.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 比赛类
 * 被观察对象
 * @author Administrator
 *
 */
public class Match implements Subject
{
    private String matchInfo;
    /**
     * 观察者集合
     */
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();
    
    public Match(String matchInfo)
    {
        this.matchInfo = matchInfo;
    }
    /**
     * 通知所有观察者
     */
    public void notifyObserver()
    {
        for (Subscriber subscriber : subscribers)
        {
            subscriber.message(matchInfo);
        }
    }
    public String getMatchInfo()
    {
        return matchInfo;
    }
    public void setMatchInfo(String matchInfo)
    {
        this.matchInfo = matchInfo;
    }
    public List<Subscriber> getSubscribers()
    {
        return subscribers;
    }
    public void setSubscribers(List<Subscriber> subscribers)
    {
        this.subscribers = subscribers;
    }
    
}
