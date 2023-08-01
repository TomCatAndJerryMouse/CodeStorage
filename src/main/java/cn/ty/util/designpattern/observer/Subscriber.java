package cn.ty.util.designpattern.observer;

/**
 * @author Administrator
 *
 */ 
public class Subscriber implements Observer
{
    /**
     */
    private String username;
    
    public Subscriber(String username)
    {
      this.username = username;
    }
    
    /**
     */
    public void message(String str)
    {
        System.out.println(username + " " + str  + " " );
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
