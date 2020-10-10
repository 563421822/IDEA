package com.qf.Annotation;

public class Teacher {

    @MyAnnotation
    public String tname;

    @MyAnnotation(name = "小雨", age = 60)
    public void show1() {

    }
}
