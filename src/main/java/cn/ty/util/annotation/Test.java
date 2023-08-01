package cn.ty.util.annotation;

import java.lang.reflect.Method;

/**
 * @author Administrator
 *定义的注解类
 */
public class Test
{
    public static void main(String[] args)
    {

        Method[] mths = Moudle.class.getMethods();

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
