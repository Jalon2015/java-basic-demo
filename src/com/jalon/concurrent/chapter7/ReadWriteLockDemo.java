package com.jalon.concurrent.chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *  读写锁 demo
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/23
 */
public class ReadWriteLockDemo {

    private int i = 0;
    private Lock readLock;
    private Lock writeLock;


    public ReadWriteLockDemo() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
    }

    public void readFun(){
        readLock.lock();
        System.out.println("=== 获取到 读锁 ===");
        try {
            System.out.println(i);
        }finally {
            readLock.unlock();
            System.out.println("=== 释放了 读锁 ===");
        }
    }

    public void writeFun(){
        writeLock.lock();
        System.out.println("=== 获取到 写锁 ===");
        try {
            i++;
            System.out.println(i);
        }finally {
            writeLock.unlock();
            System.out.println("=== 释放了 写锁 ===");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        ExecutorService executors = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executors.submit(()->{
                demo.writeFun();
//                demo.readFun();
            });
        }
    }

}
