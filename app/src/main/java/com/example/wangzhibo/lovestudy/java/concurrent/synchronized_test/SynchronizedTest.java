package com.example.wangzhibo.lovestudy.java.concurrent.synchronized_test;

/**
 * synchornized 关键字测试
 * 1.加锁方法和普通方法可以同时访问
 * Created by samwangzhibo on 2019/4/2.
 */

public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest obj = new SynchronizedTest();

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread A");
                obj.syncA();
            }
        };

        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread B");
                obj.B();
            }
        };

        Thread a = new Thread(runnableA, "A");
        Thread b = new Thread(runnableB, "B");

        a.start();
        Thread.sleep(100);
        b.start();

    }

    public synchronized void syncA(){
//        B();
        syncB();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : syncA");
    }

    public synchronized void syncB(){
//        syncA();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " : syncB");
    }

    public void B(){
        System.out.println("B");
    }

    public void C(){
        System.out.println("C");
    }
}
