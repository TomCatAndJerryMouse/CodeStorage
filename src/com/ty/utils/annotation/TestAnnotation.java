package com.ty.utils.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * �����ע����
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String invok();
}
