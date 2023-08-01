package cn.ty.util.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Match implements Subject
{
    private String matchInfo;
    /**
     */
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();
    
    public Match(String matchInfo)
    {
        this.matchInfo = matchInfo;
    }
    /**
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
