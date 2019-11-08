package com.example.wangzhibo.lovestudy.java.extends_test;

/**
 * Created by samwangzhibo on 2019/4/1.
 */

public class Parent {
  // 静态
  private static String staticI = "parent_static_i";
  private static String staticIB = "parent_static_b";

  // 非静态
  protected String i = "parent_i";
//  protected String b = "parent_b";

    protected static void staticMethod(){
        System.out.println(staticI);
    }

    protected static void staticMethodB(){
        System.out.println(staticIB);
    }

    void methodA(){
      System.out.println("parent i=" + i);
    }

    void pringtI(){
      System.out.println("parent i = " + i);
    }
}
