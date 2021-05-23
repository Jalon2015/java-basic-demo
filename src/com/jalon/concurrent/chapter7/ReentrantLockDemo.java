package com.jalon.concurrent.chapter7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *  Lock锁相关demo
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/22
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock();

    private int i = 0;

    public void add(){
        lock.lock();
        try {
            i++;
            for (int j = 0; j < 1000000; j++) {
                int m = j*i;
            }
        } finally {
            System.out.println(i);
            lock.unlock();
        }
    }

    public void tryAdd(){
        if(lock.tryLock()){
            try {
                i++;
            }finally {
                System.out.println(i);
                lock.unlock();
            }
        }
    }

    public void interruptAdd(){
        try {
            lock.lockInterruptibly();
            i++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getId()+" - "+i);
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            if (10 == i){
                System.out.println("shoutdown");
                service.shutdownNow();
            }
            service.submit(()->{
//                demo.add();
//                demo.tryAdd();
                demo.interruptAdd();
            });
        }

    }
}
