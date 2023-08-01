package cn.ty.util.designpattern.observer;

/**
 * ���
 * @author Administrator
 *
 */
public class TestMain
{
    /**
     *
     * @param 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException
    {
        Match match = new Match("中国 ：巴林");
        Subscriber subscriber1 = new Subscriber("汤姆猫");
        Subscriber subscriber2 = new Subscriber("杰瑞鼠");
        Subscriber subscriber3 = new Subscriber("大熊");
        Subscriber subscriber4 = new Subscriber("光头强强");
        match.getSubscribers().add(subscriber1);
        match.getSubscribers().add(subscriber2);
        match.getSubscribers().add(subscriber3);
        match.getSubscribers().add(subscriber4);
        Thread.sleep(5000);
        match.notifyObserver();
        
    }
}
