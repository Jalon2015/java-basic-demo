package com.jalon.concurrent.future;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <p>
 *  CompletionFuture是Java8新增的一个Future接口，对Future进行了扩展
 *
 *  比如Future获取数据如果数据没处理完，只能阻塞等待；
 *  而它可以通过complete方法来传递数据，通知数据处理完成，此时获取数据的方法就会执行，不再阻塞
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/31 12:03
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        service.execute(new MyRunnable(completableFuture));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("给 CompletableFuture 赋值");
        completableFuture.complete(10);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
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
class MyRunnable implements Runnable{
    private CompletableFuture<Integer> completableFuture;

    public MyRunnable(CompletableFuture<Integer> completableFuture) {
        this.completableFuture = completableFuture;
    }

    @Override
    public void run() {
        try {
            System.out.println("阻塞获取 CompletableFuture 的数据");
            int num = completableFuture.get();
            System.out.println(num * num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}