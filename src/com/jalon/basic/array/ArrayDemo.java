package com.jalon.basic.array;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        // 数组长度
        int length = arr.length;
        // 数组第一个元素
        String a1 = arr[0];
        // 数组转为字符串，需借助Arrays工具类
        String res = Arrays.toString(arr);

        System.out.println(length);
        System.out.println(a1);
        System.out.println(res);
        System.out.println(arr);
    }
}
