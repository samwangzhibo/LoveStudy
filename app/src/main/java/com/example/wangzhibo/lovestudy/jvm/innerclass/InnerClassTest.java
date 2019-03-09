package com.example.wangzhibo.lovestudy.jvm.innerclass;

/**
 * 这是讲静态内部类和内部类 包访问域问题
 * 1.通过javap反编译工具可以看出 其实内部类的构造函数被编译器修改，增加了外部类的引用，所以内部类能够访问外部类
 * 2.至于为啥内部类能够访问外部类的私有变量 和 外部类为啥能访问内部类的私有变量
 * 是因为编译器检查到你在使用私有变量  会动态的生成一个default权限的access()方法来返回私有变量
 * 编译器检查到你在使用私有方法  会动态的生成一个default权限的access()方法来调用私有方法
 *
 * 静态内部类
 * 1.静态内部类能够访问外部类的私有的静态方法和静态属性  不能访问非静态成员
 *
 *
 * Created by samwangzhibo on 2019/1/24.
 */

public class InnerClassTest {
    private int aNum = 1;
    private static int staticNum = 1;

    public static void main(String[] args) {
        new InnerClassTest().a();
    }

    private void a() {
        new InnerClass().innerMethod();
        new StaticInnerClass().innerMethod();
    }

    void b() {

    }

    private void c() {

    }

    public void d(){

    }

    private static void e(){

    }

    /**
     * 内部类不能有静态的方法和成员变量。
     */
    private class InnerClass {
//        private static int staticNum = 1;

//        public static void innerA(){
//
//        }
        private void innerMethod() {
            c();
            aNum = 2;
            staticNum = 1;
        }
    }

    public static class StaticInnerClass {

        private void innerMethod() {
            //non-static method c() cannot be refenrenced from a static context
//            c();
            e();
            staticNum = 2;
            //non-static field aNum cannot be refenrenced from a static context
//            aNum = 2;
        }
    }
}
