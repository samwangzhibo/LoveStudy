package com.example.wangzhibo.lovestudy.java.threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 * Created by samwangzhibo on 2019/3/7.
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
//        testFixThreadPool();

//        testSingleThreadPool();

        testScheduledThreadPool();

//        testCacheThreadPool();
    }

    private static void testCacheThreadPool() {
        ExecutorService cacheThreadExecutor= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cacheThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void testScheduledThreadPool() {
        //执行定时 / 周期性 任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 30; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            scheduledThreadPool.execute(runnable);
        scheduledThreadPool.schedule(runnable, 1, TimeUnit.SECONDS); //1s之后执行
            scheduledThreadPool.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS); //1s之后执行，每隔1s执行一次
        }

//        scheduledThreadPool.shutdown();
    }

    private static void testSingleThreadPool() {
        //顺序执行
        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
//        singleThreadExecutor.shutdown();
    }

    private static void testFixThreadPool() {
        //快速响应
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            fixThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixThreadPool.shutdown();
    }


}
