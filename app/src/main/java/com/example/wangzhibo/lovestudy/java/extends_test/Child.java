package com.example.wangzhibo.lovestudy.java.extends_test;

/**
 * 静态方法和静态属性
 * 和普通的方法重写不同
 * 如果子类有属性和方法  调用的方法就是子类的
 * 如果子类有属性 但是没有方法  调用的方法就是父类的方法  属性是父类的
 * Created by samwangzhibo on 2019/4/1.
 */

public class Child extends Parent {
  // 静态
  private static String staticI = "child_static_i";
  protected static String staticIB = "child_static_b";

  // 非静态
  protected String i = "child_i";
  protected String b = "child_b";

  @Override
  void methodA() {
    System.out.println("Child i = " + i);
  }

  protected static void staticMethod() {
    System.out.println(staticI);
  }

  void methodB(){
    System.out.println("child i = " + i);
  }

}
