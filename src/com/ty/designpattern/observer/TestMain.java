package com.ty.designpattern.observer;

/**
 * ���
 * @author Administrator
 *
 */
public class TestMain
{
    /**
     * Main����
     * @param 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException
    {
        Match match = new Match("�й� ������");
        Subscriber subscriber1 = new Subscriber("��ķè");
        Subscriber subscriber2 = new Subscriber("������");
        Subscriber subscriber3 = new Subscriber("����");
        Subscriber subscriber4 = new Subscriber("��ͷǿǿ");
        match.getSubscribers().add(subscriber1);
        match.getSubscribers().add(subscriber2);
        match.getSubscribers().add(subscriber3);
        match.getSubscribers().add(subscriber4);
        Thread.sleep(5000);
        match.notifyObserver();
        
    }
}
