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
    public static void main(String[] args) {
        // 初始化
        List<String> list = new ArrayList<>();
        list.add("hello world 1");
        list.add("hello world 2");
        list.add("hello world 3");

    }
}
