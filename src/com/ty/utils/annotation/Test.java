package com.ty.utils.annotation;

import java.lang.reflect.Method;

/**
 * 入口
 * @author Administrator
 *
 */
public class Test
{
    public static void main(String[] args)
    {
        //获取Method所有的函数
        Method[] mths = Moudle.class.getMethods();
        //打印出Method类每个函数上的注解
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
