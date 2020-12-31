package com.jalon.concurrent.chapter5.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 并发容器：ConcurrentHashMap
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/5
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(()->{
                for (int k = 0; k < 1000; k++) {
                    map.put(String.valueOf(j*1000+k), j*1000+k);
                }
            }).start();
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(()->{
                for (int k = 0; k < 1000; k++) {
                    map2.put(String.valueOf(j*1000+k), j*1000+k);
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(map.size());
        System.out.println(map2.size());
    }
}
