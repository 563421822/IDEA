package com.qf.Enum;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();

        // 用对象调用属性赋值

        stu.sname = "小明";
        stu.ssex = Sex.男;


        //调用枚举类型中实例方法
        stu.ssex.aa();

        //调用枚举类型中静态方法
        stu.ssex.bb();
        Sex.bb();

        System.out.println("stu = " + stu);


    }
}
