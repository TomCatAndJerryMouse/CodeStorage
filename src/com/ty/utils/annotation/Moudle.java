package com.ty.utils.annotation;
/**
 * ◊¢Ω‚≤‚ ‘¿‡
 * @author Administrator
 */
public class Moudle {
    @TestAnnotation(invok="Annotation1")
    public void run()
    {
        System.out.println("test1");
    }
    @TestAnnotation(invok="Annotation2")
    public void stop()
    {
        System.out.println("test2");
    }
}
