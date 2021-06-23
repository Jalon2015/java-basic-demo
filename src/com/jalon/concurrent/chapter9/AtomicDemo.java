package com.jalon.concurrent.chapter9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/6/17 17:17
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                // 这里会先检查AtomicInteger中的值是否被修改，如果没被修改，才会更新，否则会自旋等待
                atomicInteger.getAndIncrement();
                // 最新的版本，都是用适应性自旋锁
            });
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get());
    }
}
