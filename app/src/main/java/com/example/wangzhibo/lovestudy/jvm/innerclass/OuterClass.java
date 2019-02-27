package com.example.wangzhibo.lovestudy.jvm.innerclass;

/**
 * 同一包下面的类 不能访问别人的私有方法
 *
 * 同一包下面 不能访问同包的其他类的私有对象
 * 同一包下面 能访问同包的其他类的私有对象
 * 不能访问其他类的内部类
 * 可以访问其他类的静态内部类
 *
 * Created by samwangzhibo on 2019/1/24.
 */

public class OuterClass {
    public static void main(String[] args) {
        //找不到InnerClassTest的私有方法a
//        new InnerClassTest().a;

        //default的可以统一包访问
        new InnerClassTest().b();

        //外部类不能访问同包以下的private static方法
//        InnerClassTest.e();

        //不能访问同一包下的内部类
//        new InnerClassTest.InnerClass();
        //能访问同一包下的静态内部类
        new InnerClassTest.StaticInnerClass();
    }
}
