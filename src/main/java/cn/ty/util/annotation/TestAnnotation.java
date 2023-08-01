package cn.ty.util.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    /**
     * invok
     * @return
     */
    String invok();
}
