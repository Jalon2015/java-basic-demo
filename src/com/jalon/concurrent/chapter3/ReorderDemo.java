package com.jalon.concurrent.chapter3;

/**
 * <p>
 *  指令重排序
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/29
 */
public class ReorderDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int m = a + b;
        int c = 1;
        int d = 2;
        int n = c - d;
    }
}
