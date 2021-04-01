package com.jalon.basic.collection;

import java.util.*;

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
        // HashSet
        // 初始化
//        Set<Integer> set = new HashSet<>();
//        // 添加元素
//        set.add(10);
//        // 元素数量
//        int size = set.size();
//        System.out.println(size);
//        // 查询元素是否存在
//        boolean isContain = set.contains(10);
//        System.out.println(set);
//        // 删除
//        set.remove(10);
//        System.out.println(set);

        // TreeSet
        B b = new B();
        // 初始化
        Set<B> set2 = new TreeSet<>();
        // 添加元素
        set2.add(b);
        // 元素数量
        int size2 = set2.size();
        // 查询元素是否存在
        boolean isContain2 = set2.contains(b);
        // 删除
        set2.remove(b);

        // LinkedHashSet
        Set<B> set3 = new LinkedHashSet<>();
        set3.add(new B());

        sort();
    }

    public static void sort(){
        // HashSet
        Set<String> set = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        Set<String> set3 = new LinkedHashSet<>();
        int i=100;
        int j=100;
        int k=100;
        while (i-->0){
            set.add(i+"");
        }
        System.out.println(set);
        // TreeSet
        while (j-->0){
            set2.add(j+"");
        }
        System.out.println(set2);
        // LinkedHashSet
        while (k-->0){
            set3.add(k+"");
        }
        System.out.println(set3);
    }
}
class B implements Comparable{
    @Override
    public int compareTo(Object o) {
        return this.hashCode()>o.hashCode() ? 1 : -1;
    }
}
