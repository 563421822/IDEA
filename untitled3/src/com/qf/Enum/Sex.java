package com.qf.Enum;

public enum Sex {
    男, 女, man, woman, male, female;
    /**
     * 属性
     */
    public String name;

    /**
     * 枚举类型中所有构造方法都是私有的
     */
    private Sex() {
        System.out.println("com.qf.Test.Sex.Sex的无参构造");
    }

    private Sex(String name) {
        this.name = name;
        System.out.println("com.qf.Test.Sex.Sex的全参构造");
    }

    /**
     * 静态方法
     */
    public static void bb() {
        System.out.println("枚举静态方法");
    }

    /**
     * 实例方法
     */
    @Deprecated
    public void aa() {
        System.out.println("枚举普通实例方法");
    }
}
