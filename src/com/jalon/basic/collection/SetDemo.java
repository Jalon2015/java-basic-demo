package com.jalon.basic.collection;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author: jalon2015
 * @date: 2021/3/30 15:17
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int i = 1000;
        while (i-->0){
            set.add(i);
        }
        System.out.println(set.toString());

    }
}
