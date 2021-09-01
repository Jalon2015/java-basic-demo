package com.jalon.concurrent.future;

import java.util.concurrent.*;

/**
 * <p>
 *  Java内置的Future
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/30 16:49
 */
public class JavaFutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> submit = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                return "hello";
            }
        });
        System.out.println("任务已提交，等待结果");
        try {
            String s = submit.get();
            System.out.println("结果为：" + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
