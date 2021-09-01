package com.jalon.concurrent.future;

import java.util.concurrent.*;

/**
 * <p>
 *  CompletableFuture：流式调用
 *  Future在获取数据时，会阻塞，而它可以在数据计算完成后通知到对方，见下面的代码
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/31 12:03
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) {

        // supplyAsync为工厂方法，构建一个CompletableFuture对象
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // 这里的任务会放在 ForkJoinPool.common 线程池中运行
            // 如果 supplyAsync 显式指定了线程池，则在指定的线程池中运行
            try {
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10/0;
            // 这里的thenApply的参数i，就是上面的异步任务返回的结果；
            // 这样就不需要类似Future.get那样的方法进行阻塞，减少了等待耗时
        }).exceptionally(e->{
            e.printStackTrace();
            return 0;
        })
                .thenApply(i -> {
            System.out.println("计算完成："+i);
            return i;
        }) ;
        // 上面这个流式操作在Java8中很常见，比如List.stream

        // 下面这个是future的用法，需阻塞获取数据
        try {
            future.get();
            System.out.println("等待完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

