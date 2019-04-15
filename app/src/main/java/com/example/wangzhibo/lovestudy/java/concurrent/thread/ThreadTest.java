package com.example.wangzhibo.lovestudy.java.concurrent.thread;

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

        /**
         *  通过 Join() 实现线程同步打印
         *
         */
//        testSyncThreadByJoin();

        /**
         * 测试{@link #wait()}
         * 1.如果wait限时等待的时候，锁被占了还能唤醒吗?
         * 不能  wait限时等待的前提是 线程能被分配锁
         */
        testWait();

        //同步打印
//        printByOrder();

        /**
         * 测试 Interrupt()方法
         * https://www.zhihu.com/question/41048032
         */
//        testInterrupt();

//        testYield();
    }

    private static void testWait() {
        Object object = new Object();

        Thread a = new Thread("A"){
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "等待");
                    try {
                        object.wait(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "恢复");
                }
            }
        };

        Thread b = new Thread("B"){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "抢占锁");
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
        };

        a.start();
        b.start();
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
                System.out.println("Consumer : yield end");
            }
        }
    }

    static class Producer extends Thread{
        @Override
        public void run() {
            for (int i=0; i< 5; i++){
                System.out.println("Producer : " + i);
                Thread.yield();
                System.out.println("Producer : yield end");
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
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
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

                /**
                 * 3.wait 等待的时候 如果锁没有被其他线程占用 也会抛出中断异常
                 *  如果锁被占用 不能抛出异常
                  */
//                while (true) {
                    synchronized (lockObj) {
                        if (threadName.equals("B")){
                            while (true){
                                try {
                                    Thread.sleep(1000);
                                    System.out.println(threadName + " ping pong");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            System.out.println(Thread.currentThread().getName() + ": wait 开始");
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": wait 结束");
                    }
//                }

            }
        };
        Thread a = new Thread(runnable, "A");
        a.start();

        Thread b = new Thread(runnable, "B");
        b.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
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

    /**
     * 测试join
     */
    private static void testSyncThreadByJoin() {
        int i = 1;
        final Thread thread1 = new Thread("A"){
            @Override
            public void run() {
//                while (true){
                    try {
                        System.out.println("thread1 ");
                        Thread.sleep(30000);
                        System.out.println("thread1 end ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }
        };
        final Thread thread2 = new Thread("B"){
            @Override
            public void run() {
//                while (true) {
                    try {
                        System.out.println("thread2 join before ");
                        thread1.join(2000);
                        System.out.println("thread2 end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }
        };

        Thread thread3 = new Thread("C"){
            @Override
            public void run() {
//                while (true) {
                    try {
                        System.out.println("thread3 join before ");
                        thread2.join();
                        System.out.println("thread3 end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }


    /**
     * 3个线程 顺序打印
     */
    private static char c = 'A';
    private static volatile int i = 0;
    public static void printByOrder() {
        Runnable runnable = new Runnable() {
            public void run() {
                synchronized (this) {//加锁
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.println(threadId +""+ (char) c++);
                                i++;
                                notifyAll();// 唤醒处于等待状态的线程
                            } else {
                                wait();// 释放当前锁并进入等待状态
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//执行结束释放当前锁
            }
        };
        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "3");
        t1.start();
        t2.start();
        t3.start();
    }

}
