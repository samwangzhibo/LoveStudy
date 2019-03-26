package com.example.wangzhibo.lovestudy.java.concurrent.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁测试
 *
 * ReentrantLocak特性（对比synchronized）
 * 尝试获得锁
 * 获取到锁的线程能够响应中断
 *
 * Created by samwangzhibo on 2019/3/19.
 */

public class ReentrantLockTest {
    private ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();
    void syncMethod(){
        reentrantLock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + (" " + (i + 1)));
        }
        reentrantLock.unlock();
    }

    void testAwait(){
        reentrantLock.lock();
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "上锁了");
        for (int i=0; i < 5; i++){
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + i);
        }
        condition.signal();
        reentrantLock.unlock();
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "解锁了");
    }

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                reentrantLockTest.syncMethod();
                reentrantLockTest.testAwait();
            }
        };
        Thread a = new Thread(runnable, "A");
        a.start();
        Thread.sleep(50);
        new Thread(runnable, "B").start();
        Thread.sleep(50);
        new Thread(runnable, "C").start();

    }
}
