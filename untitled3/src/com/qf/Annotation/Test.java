package com.qf.Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
//        获得老师类的反射对象(类对象)
        Class clazz = Class.forName("com.qf.Annotation.Teacher");
//        获得姓名属性的反射对象
        Field tnameField = clazz.getDeclaredField("tname");
//        通过属性反射对象获得注解对象
        MyAnnotation ma1 = tnameField.getAnnotation(MyAnnotation.class);
        System.out.println("ma1.name()+ma1.age() = " + ma1.name() + ma1.age());

//        获得方法的反射对象
        Method showMethod = clazz.getDeclaredMethod("show1");
        MyAnnotation ma2 = showMethod.getAnnotation(MyAnnotation.class);
        System.out.println("ma2.name()+ma2.age() = " + ma2.name() + ma2.age());

    }
}
