package com.jalon.basic.collection;

import java.util.*;

/**
 * <p>
 *   List:是一组元素的线性集合
 *   ArrayList（最常用）:随机序列，适合随机访问
 *   LinkedList:有序访问，适合插入
 * </p>
 *
 * @author: jalon2015
 * @date: 2021/3/30 15:16
 */
public class ListDemo {
    public static void addAll(){
        List<String> list = new ArrayList<>();
        list.addAll(Collections.nCopies(10, "hello"));
        System.out.println(list);
    }
    public static void main(String[] args) {
        addAll();
        // 初始化
        List<String> list = new ArrayList<>();
        // 插入数据
        list.add("hello world 1");
        // 在指定位置插入数据
        list.add(0, "hello world 2");
        // 查询数据
        String s1 = list.get(0);
        // 查询List是否包含指定对象
        boolean isContain = list.contains(s1);
        // 查询列表的元素个数
        int size = list.size();
        // 打印list内部元素：
        String res = list.toString();

        System.out.println(res);

    }
}
