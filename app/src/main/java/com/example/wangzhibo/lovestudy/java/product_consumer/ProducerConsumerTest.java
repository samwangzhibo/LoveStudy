package com.example.wangzhibo.lovestudy.java.product_consumer;

/**
 * Created by samwangzhibo on 2019/3/11.
 */

public class ProducerConsumerTest {
    private int num = 0;
    private final Object lockObj = new Object();

    public static void main(String[] args) {
        final ProducerConsumerTest producerConsumerTest = new ProducerConsumerTest();
        //生产者
        Thread producer = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true) {
                    synchronized (producerConsumerTest.lockObj) {
                        if (producerConsumerTest.num >= 5) { //大于容积 生产者拥塞
                            try {
                                producerConsumerTest.lockObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        producerConsumerTest.lockObj.notify();
                        producerConsumerTest.num++;
                        System.out.println("生产者开始生产 " + producerConsumerTest.num);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        //消费者
        Thread consumer = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true) {
                    synchronized (producerConsumerTest.lockObj) {
                        if (producerConsumerTest.num == 0) { //消费完 拥塞
                            try {
                                producerConsumerTest.lockObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        producerConsumerTest.lockObj.notify();
                        producerConsumerTest.num--;
                        System.out.println("消费者消费 " + producerConsumerTest.num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };


        consumer.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start();
    }
}
