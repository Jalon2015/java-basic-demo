package com.jalon.concurrent.chapter2;

/**
 * <p>
 *  stop()方法，已废弃，这里举个反例
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/24
 */
public class StopDemo {
    private static int a = 1;
    private static int b = 1;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            a = 2;
            Thread.currentThread().stop();
            b = 2;
        }).start();
        Thread.sleep(1000);
        System.out.println(a);
        System.out.println(b);
    }
}
