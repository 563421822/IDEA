package com.qf.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类型
 * 注意:注解在使用时一定要有值,要么用默认值,要么手动赋值
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
    /**
     * 姓名属性
     */
    String name() default "小明";

    /**
     * 年龄属性,相当于类中的方法
     */
    int age() default 18;
    /**
     * 老师类
     */
}