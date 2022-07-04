package com.jalon.concurrent.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  不安全的类：有一个状态变量
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/24
 */
public class UnSafeDemo {
    static final AtomicInteger a = new AtomicInteger(0);
//    static int a = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()-> {
            for(int j=0;j<100000;j++){
                a.incrementAndGet();
            }
        }).start();

        new Thread(()-> {
            for(int j=0;j<100000;j++){
                a.incrementAndGet();
            }
        }).start();

        Thread.sleep(3000);
        System.out.println(a.get());
    }
}
