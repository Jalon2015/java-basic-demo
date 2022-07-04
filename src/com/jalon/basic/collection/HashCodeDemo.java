package com.jalon.basic.collection;

import java.util.*;

/**
 * <p>
 *  hashCode和equals的区别
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/9 13:03
 */
public class HashCodeDemo{

    public static void main(String[] args) {
        HashCodeDemo demo1 = new HashCodeDemo(1);
        HashCodeDemo demo2 = new HashCodeDemo(1);
        Map<HashCodeDemo, Integer> map = new HashMap<>();
        map.put(demo1, 1);
        map.put(demo2, 2);
        System.out.println(map.get(demo1)); // 输出1
        System.out.println(map.get(demo2)); // 输出2
    }

    private int n;

    public HashCodeDemo(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeDemo that = (HashCodeDemo) o;
        return n == that.n;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(n);
//    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}

