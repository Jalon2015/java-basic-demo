package com.jalon.concurrent.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *  闭锁Demo
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/2
 */
public class CountDownLatchDemo {
    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    demo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        demo.latch.countDown();

    }
}
