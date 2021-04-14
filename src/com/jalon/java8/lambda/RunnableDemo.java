package com.jalon.java8.lambda;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/14 15:09
 */
public class RunnableDemo {
    public static void main(String[] args) {
        // Java8之前：旧的写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("old run");
            }
        };
        // Java8之后：新的写法
        Runnable runnable1 = ()->{
            System.out.println("lambda run");
        };
        Thread t = new Thread(runnable);
        Thread t1 = new Thread(runnable1);
        t.start();
        t1.start();
    }
}
