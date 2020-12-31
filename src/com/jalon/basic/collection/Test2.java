package com.jalon.basic.collection;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/9 17:44
 */
public class Test2 {
    public static void main(String[] args) {
        Object t = new Object();
        int a = t.hashCode();
        System.out.println(Integer.toHexString(a)); // 输出 4554617c
    }
}
