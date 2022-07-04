package com.jalon.concurrent.chapter6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *  固定容量的线程池
 *  通过添加VM参数（-Xmx8m -Xms8m），可以在运行时报错OOM
 *  参考：https://my.oschina.net/langwanghuangshifu/blog/3208320
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/5/18 11:23
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1_000_000; i++) {
            try{
                executorService.execute(()->{
                    // 报错如下：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
                    //	at java.util.concurrent.LinkedBlockingQueue.offer(LinkedBlockingQueue.java:416)
                    //	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1371)
                    //	at com.jalon.concurrent.chapter6.FixedThreadPoolDemo.main(FixedThreadPoolDemo.java:20)
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
