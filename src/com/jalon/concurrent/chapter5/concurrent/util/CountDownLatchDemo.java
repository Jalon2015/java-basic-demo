package com.jalon.concurrent.chapter5.concurrent.util;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *  CountDownLock例子
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/9
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 1. 构造一个倒计数器，给定一个状态值10
        CountDownLatch latch = new CountDownLatch(10);
        System.out.println("准备加载");
        // 这里我们创建10个线程，模拟 5V5 游戏的10个玩家
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                // 这里我们给点延时，模拟网络延时
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"加载100%");
                // 2. 这里的countDown就是用来改变倒计数器的内部状态，每次-1
                latch.countDown(); //这里不会阻塞当前线程，执行完后就立马返回了
            }).start();
        }
        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4所有人加载完成，开始游戏");
        }).start();
        // 3. 这里阻塞等待状态的完成，即10变为0;
        latch.await();
        System.out.println("所有人加载完成，开始游戏");
    }
}