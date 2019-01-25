package com.example.wangzhibo.lovestudy.jvm.innerclass;

/**
 * 这是讲静态内部类和内部类 包访问域问题
 * 通过javap反编译工具可以看出 其实内部类的构造函数被编译器修改，增加了外部类的引用，所以内部类能够访问外部类
 * 至于为啥内部类能够访问外部类的私有变量 和 外部类为啥能访问内部类的私有变量
 * 是因为编译器检查到你在使用私有变量  会动态的生成一个default权限的access()方法来返回私有变量
 * 编译器检查到你在使用私有方法  会动态的生成一个default权限的access()方法来调用私有方法
 * Created by samwangzhibo on 2019/1/24.
 */

public class InnerClassTest {
    public static void main(String[] args) {
        new InnerClassTest().a();
    }
    private void a(){
        new InnerClass().innerMethod();
//        new StaticInnerClass().innerMethod();
    }
    void b(){

    }
    private void c(){

    }
    private int aNum = 1;
    private class InnerClass{
        private void innerMethod(){
            c();
            aNum = 2;
        }
    }
//    public  class InnerClass2{
//        private void innerMethod(){
//
//        }
//    }
//
//    private static class StaticInnerClass{
//        private void innerMethod(){
//
//        }
//    }
//
//    public static class StaticInnerClass2{
//        private void innerMethod(){
//
//        }
//    }
}
