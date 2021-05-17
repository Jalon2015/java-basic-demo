package com.jalon.concurrent.chapter6;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>
 *  Executor框架：操作各种线程池
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/16
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        // 容量固定的线程池
        Executor fixedThreadPool = Executors.newFixedThreadPool(5);
        // 容量动态增减的线程池
        Executor cachedThreadPool = Executors.newCachedThreadPool();
        // 单个线程的线程池
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 基于调度机制的线程池（不同于上面的线程池，这个池创建的任务不会立马执行，而是定期或者延时执行）
        Executor scheduledThreadPool = Executors.newScheduledThreadPool(5);

    }
}
