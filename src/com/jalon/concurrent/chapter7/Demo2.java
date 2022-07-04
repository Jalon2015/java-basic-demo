package com.jalon.concurrent.chapter7;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/23
 */
public class Demo2 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("中断");
                }
            }
        });
        t.start();
        t.interrupt();
    }
}
