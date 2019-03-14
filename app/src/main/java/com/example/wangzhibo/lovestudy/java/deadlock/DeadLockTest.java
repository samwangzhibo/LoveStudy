package com.example.wangzhibo.lovestudy.java.deadlock;

/**
 * Created by samwangzhibo on 2019/3/11.
 */

public class DeadLockTest {
    public static void main(String[] args) {
        final Object sourse1 = new Object(), sourse2 = new Object();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    synchronized (sourse1) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (sourse2) {

                        }
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };

        thread1.start();
        thread2.start();
    }
}
