package com.jalon.algorithm;

/**
 * <p>
 *  递归：自己调用自己
 *  和循环比，性能一样，甚至有时候还不如循环；但是代码清晰
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/6/18 16:39
 */
public class RecursionDemo {
    // 循环打印3...2...1...
    public static void forPrint(int n){
        while (n>0){
            System.out.println(n-- + "...");
        }
    }
    // 递归打印3...2...1...
    public static void recursionPrint(int n){
        if(n>0){
            System.out.println(n-- + "...");
            recursionPrint(n);
        }
    }

    public static void main(String[] args) {
        forPrint(3);
        recursionPrint(3);
    }
}
