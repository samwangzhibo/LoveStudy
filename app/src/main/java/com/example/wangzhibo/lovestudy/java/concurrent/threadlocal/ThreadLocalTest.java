package com.example.wangzhibo.lovestudy.java.concurrent.thread.threadlocal;

/**
 * Created by samwangzhibo on 2019/3/11.
 */

public class ThreadLocalTest {
    private ThreadLocal<Integer> numThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        new Thread(){
            @Override
            public void run() {
                super.run();
                threadLocalTest.numThreadLocal.set(2);
                try {
                    Thread.sleep(3000); //等1s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + " : num = " + threadLocalTest.numThreadLocal.get());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                threadLocalTest.numThreadLocal.set(4);
                try {
                    Thread.sleep(1000); //等3s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + " : num = " + threadLocalTest.numThreadLocal.get());
            }
        }.start();
    }
}
