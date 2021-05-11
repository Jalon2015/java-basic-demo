package com.jalon.concurrent.chapter5.concurrent.util;

import java.util.Timer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  信号量demo：多用来做资源池
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/9
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        System.out.println("准备第一轮团战");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"=>获取了许可");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        while (semaphore.availablePermits()!=0){

        }

        // 等待1S，模拟团战前的准备工作
        Thread.sleep(1000);
        System.out.println("开始第一轮团战");
        // 等待3S，模拟团战的过程
        Thread.sleep(1000);
        System.out.println("团战结束 => 释放许可");
        // 释放所有许可，下次团战再用
        semaphore.release(10);

        while (semaphore.availablePermits() != 10){

        }
        System.out.println("准备第二轮团战");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" => 获取了许可");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        while (semaphore.availablePermits()!=0){
        }
        // 等待1S，模拟团战前的准备工作
        Thread.sleep(1000);
        System.out.println("开始第二轮团战");
        // 等待3S，模拟团战的过程
        Thread.sleep(1000);
        System.out.println("团战结束 => 释放许可");
        // 释放所有许可，下次团战再用
        semaphore.release(10);
    }
}
