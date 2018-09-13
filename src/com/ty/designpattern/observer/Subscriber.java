package com.ty.designpattern.observer;

/**
 * ������
 * �۲���
 * @author Administrator
 *
 */ 
public class Subscriber implements Observer
{
    /**
     *���������� 
     */
    private String username;
    
    public Subscriber(String username)
    {
      this.username = username;
    }
    
    /**
     * ���ͱ�����Ϣ
     */
    public void message(String str)
    {
        System.out.println(username + "�㶩�ĵı��� " + str  + " ������ʼ��" );
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
