package com.jalon.concurrent.chapter6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  阿里推荐：单独使用 ThreadPoolExecutor
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/5/18 12:46
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                1, // 核心线程数
                1, // 最大线程数
                60L, // 空闲时间
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1), // 数组工作队列，长度1
                new ThreadPoolExecutor.DiscardPolicy()); // 拒绝策略：丢弃
        for (int i = 0; i < 1_000_000; i++) {
            // 通过这里的打印信息，我们可以知道循环了3次
            // 原因就是第一次的任务在核心线程中执行，第二次的任务放到了工作队列，第三次的任务被拒绝执行
            System.out.println(i);
            service.execute(()->{
                // 这里会报异常，是因为执行了拒绝策略（达到了最大线程数，队列也满了，此时新进来的任务就会执行拒绝策略）
                // 这里需要注意的是，抛出异常后，代码并不会退出，而是卡在异常这里，包括主线程也会被卡住(这个是默认的拒绝策略）
                // 我们可以用其他的拒绝策略，比如DiscardPolicy,此时代码就会继续往下执行
                System.out.println(Thread.currentThread().getName());
            });
        }
        try {
            Thread.sleep(1000);
            System.out.println("主线程 sleep ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
