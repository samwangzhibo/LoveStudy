package com.example.wangzhibo.lovestudy.java.thread;

/**
 * 线程测试
 * 包括 为什么要线程同步  join()方法实现线程同步  interrupt中段标志结束线程
 * Created by samwangzhibo on 2019/3/13.
 */

public class ThreadTest {
    //    public volatile static int num = 0;
    public static int num = 0;

    public static void main(String[] args) {
        //证明为什么需要线程同步
//        whyNeedSync();

        //通过 Join() 实现线程同步打印
//        testSyncThreadByJoin();

        /**
         * 测试 Interrupt()方法
         * https://www.zhihu.com/question/41048032
         */
//        testInterrupt();

        testYield();
    }

    /**
     * 测试 yield方法
     * 放弃自己的时间片 wait状态 等其他线程运行
     */
    private static void testYield() {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();

//        consumer.setPriority(Thread.MIN_PRIORITY);
//        producer.setPriority(Thread.MAX_PRIORITY);

        consumer.start();
        producer.start();
    }

    static class Consumer extends Thread{
        @Override
        public void run() {
            for (int i=0; i< 5; i++){
                System.out.println("Consumer : " + i);
                Thread.yield();
            }
        }
    }

    static class Producer extends Thread{
        @Override
        public void run() {
            for (int i=0; i< 5; i++){
                System.out.println("Producer : " + i);
                Thread.yield();
            }
        }
    }

    /**
     * interrupt() 不会中断线程，只是改变中断字段的值，让线程自己处理
     * 具体来说，当对一个线程，调用 interrupt() 时，
     * ① 如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），那么线程将立即退出被阻塞状态，
     * 并抛出一个InterruptedException异常。仅此而已。
     * ② 如果线程处于正常活动状态，那么会将该线程的中断标志设置为 true，仅此而已。
     * 被设置中断标志的线程将继续正常运行，不受影响。
     *
     * 详见文档
     *
     */
    private static void testInterrupt() {
        final Object lockObj = new Object();
        Thread thread = new Thread(){
            @Override
            public void run() {
                // 1.sleep的时候 interrupt抛出InterruptedException
//                try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                // 2.正常运行的时候，调用isInterrupted()判断中断的值
//                while (!isInterrupted()){
//
//                }
//                System.out.println("线程over");

                // 3.拥塞的时候 也会抛出中断异常
                while (true) {
                    synchronized (lockObj) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    private static void whyNeedSync() {
        //1.开启10个线程去修改num的值 可以看到每次执行的结果不同
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    num++;
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num = " + num);
    }

    private static void testSyncThreadByJoin() {
        final Thread thread1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 ");
            }
        };
        final Thread thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("thread2 join before ");
                    thread1.join();
                    System.out.println("thread2 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread3 = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("thread3 join before ");
                    thread2.join();
                    System.out.println("thread3 ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
