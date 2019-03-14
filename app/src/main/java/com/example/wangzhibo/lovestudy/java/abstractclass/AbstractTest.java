package com.example.wangzhibo.lovestudy.java.abstractclass;

/**
 * 抽象类 不能直接实例化 能够匿名内部类实例化
 * Created by samwangzhibo on 2019/3/14.
 */

public class AbstractTest {
    public static void main(String[] args) {
        //匿名内部类
        new Animal() {
            @Override
            void move() {
                System.out.println("移动");
            }
        };
    }
}
