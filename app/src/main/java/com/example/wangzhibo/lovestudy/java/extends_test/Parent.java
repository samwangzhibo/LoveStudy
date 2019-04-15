package com.example.wangzhibo.lovestudy.java.extends_test;

/**
 * Created by samwangzhibo on 2019/4/1.
 */

public class Parent {
    protected int i;
    protected static int staticI = 1;
    protected static int staticIB = 2;

    protected static void staticMethod(){
        System.out.println(staticI);
    }

    protected static void staticMethodB(){
        System.out.println(staticIB);
    }

    void methodA(){

    }
}
