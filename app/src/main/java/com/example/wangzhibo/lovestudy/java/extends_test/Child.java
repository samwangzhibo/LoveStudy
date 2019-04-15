package com.example.wangzhibo.lovestudy.java.extends_test;

/**
 * 静态方法和静态属性
 * 和普通的方法重写不同
 * 如果子类有属性和方法  调用的方法就是子类的
 * 如果子类有属性 但是没有方法  调用的方法就是父类的方法  属性是父类的
 * Created by samwangzhibo on 2019/4/1.
 */

public class Child extends Parent {
    protected static int staticI = 3;
    protected static int staticIB = 4;

    @Override
    void methodA() {
        super.methodA();
    }

    protected static void staticMethod() {
        System.out.println(staticI);
    }

    public static void main(String[] args) {
        System.out.println("子类 父类同时具有静态方法和静态属性  调用父类的方法  是父类的值");
        Parent.staticMethod();
        System.out.println("子类 父类同时具有静态方法和静态属性  调用子类的方法  是子类的值");
        staticMethod();

        System.out.println("父类(静态方法 静态属性) 子类(静态属性) 调用方法  是父类的");
        staticMethodB();

    }
}
