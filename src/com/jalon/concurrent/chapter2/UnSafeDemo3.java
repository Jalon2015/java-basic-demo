package com.jalon.concurrent.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  升级前-不安全的类：有多个状态变量
 *  升级后-安全的类：加final
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/24
 */
public class UnSafeDemo3 {
    static final AtomicInteger a = new AtomicInteger(0);
    static final AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 单独创建一个对象，用来充当锁
        UnSafeDemo3 unSafeDemo2 = new UnSafeDemo3();
        new Thread(()-> {
            for(int j=0;j<10000;j++){
                // 这里加了锁
                synchronized (unSafeDemo2){
                    a.incrementAndGet();
                    b.incrementAndGet();
                    if(a.get()!=b.get()){
                        // 现在肯定是理想状态，不会运行到这里
                        System.out.println(1);
                    }
                }
            }
        }).start();
        new Thread(()-> {
            for(int j=0;j<10000;j++){
                // 这里加了锁
                synchronized (unSafeDemo2){
                    a.incrementAndGet();
                    b.incrementAndGet();
                    if(a.get()!=b.get()){
                        // 现在肯定是理想状态，不会运行到这里
                        System.out.println(2);
                    }
                }
            }
        }).start();
    }
}