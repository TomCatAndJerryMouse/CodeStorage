package cn.ty.util.annotation;
/**
 * 注解测试类
 * @author Administrator
 */
public class Moudle {

    /**
     * run
     */
    @TestAnnotation(invok="Annotation1")
    public void run()
    {
        System.out.println("test1");
    }

    /**
     * stop
     */
    @TestAnnotation(invok="Annotation2")
    public void stop()
    {
        System.out.println("test2");
    }
}
