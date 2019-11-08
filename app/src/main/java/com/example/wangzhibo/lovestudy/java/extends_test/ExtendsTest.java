package com.example.wangzhibo.lovestudy.java.extends_test;

/**
 * 继承测试
 */
public class ExtendsTest {
  public static void main(String[] args) {
    Child child = new Child();
    Parent parent = new Parent();
    System.out.println("子类 重写静态方法、静态属性  调用父类的方法  是父类的值");
    parent.staticMethod();
    System.out.println("子类 重写静态属性  调用父类的方法(未重写)  是父类的值");
    child.staticMethodB();

    System.out.println("子类 重写静态方法、静态属性  调用子类的方法  是子类的值");
    child.staticMethod();

    System.out.println("子类 重写非静态属性  调用父类的方法(未重写)  是父类的值");
    child.pringtI();
    System.out.println("子类 重写非静态属性、方法  调用子类的方法  是子类的值");
    child.methodA();
  }
}
