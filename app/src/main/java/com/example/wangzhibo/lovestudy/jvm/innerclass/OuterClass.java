package com.example.wangzhibo.lovestudy.jvm.innerclass;

/**
 * 统一包下面的类 不能访问别人的私有方法
 * Created by samwangzhibo on 2019/1/24.
 */

public class OuterClass {
    public static void main(String[] args) {
        //找不到InnerClassTest的私有方法a
//        new InnerClassTest().a;

        //default的可以统一包访问
        new InnerClassTest().b();
        //内部类不能访问
        //new InnerClassTest.InnerClass2();

//        new InnerClassTest.StaticInnerClass2();
//        new InnerClassTest.StaticInnerClass();
    }
}
