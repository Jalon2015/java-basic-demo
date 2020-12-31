package com.jalon.concurrent.chapter6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *  容量可变的线程池
 *  通过添加VM参数（-Xmx8m -Xms8m），可以在运行时报错OOM
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/5/18 11:59
 */
public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        // 最大线程数为 int.max
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            service.execute(()->{
                // 报错如下： Exception in thread "pool-1-thread-5630" Exception in thread "pool-1-thread-5752" java.lang.OutOfMemoryError: GC overhead limit exceeded
                //	at java.util.concurrent.SynchronousQueue$TransferStack.snode(SynchronousQueue.java:318)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
