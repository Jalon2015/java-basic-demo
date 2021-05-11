package com.jalon.concurrent.chapter5.concurrent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/8
 */
public class HashMapDemo {

    public static void hashMapTest(){
        Map<String, String> map = new HashMap<>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            map.put("a", "a");
            map.get("a");
//            map.put(UUID.randomUUID().toString(), String.valueOf(i));
//            map.get(UUID.randomUUID().toString());
        }
        long end = System.nanoTime();
        System.out.println("hashMap耗时：");
        System.out.println(end - start);
    }

    public static void hashTableTest(){
        Map<String, String> map = new Hashtable<>();
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a", "a");
                    map.get("a");
//                    map.put(UUID.randomUUID().toString(), String.valueOf(j));
//                    map.get(UUID.randomUUID().toString());
                }
            }).start();
        }
        /**
         * 使用IntelliJ IDEA的读者请注意，在IDEA中运行这段程序，
         * 会由于IDE自动创建一条名为Monitor Ctrl-Break的线程
         * （从名字看应该是监控Ctrl-Break中断信号的）而导致while循环无法结束，
         * 改为大于2 或者用Thread::join()方法代替可以解决该问题。
         */
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        long end = System.nanoTime();
        System.out.println("hashTable耗时：");
        System.out.println(end - start);
    }

    public static void concurrentHashMapTest(){
        Map<String, String> map = new ConcurrentHashMap<>();
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a", "a");
                    map.get("a");
//                    map.put(UUID.randomUUID().toString(), String.valueOf(j));
//                    map.get(UUID.randomUUID().toString());
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        long end = System.nanoTime();
        System.out.println("concurrentHashMap耗时：");
        System.out.println(end - start);
    }


    public static void main(String[] args) {
        hashMapTest();
        hashTableTest();
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        concurrentHashMapTest();
    }
}
