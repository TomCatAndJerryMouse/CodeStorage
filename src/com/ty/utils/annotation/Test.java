package com.ty.utils.annotation;

import java.lang.reflect.Method;

/**
 * ���
 * @author Administrator
 *
 */
public class Test
{
    public static void main(String[] args)
    {
        //��ȡMethod���еĺ���
        Method[] mths = Moudle.class.getMethods();
        //��ӡ��Method��ÿ�������ϵ�ע��
        for (Method mt : mths)
        {
            boolean hasant = mt.isAnnotationPresent(TestAnnotation.class);
            if (hasant)
            {
                TestAnnotation tans = mt.getAnnotation(TestAnnotation.class);
                System.out.println(tans.invok());
            }
        }
    }
}
