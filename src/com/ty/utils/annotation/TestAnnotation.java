package com.ty.utils.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 定义的注解类
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String invok();
}
