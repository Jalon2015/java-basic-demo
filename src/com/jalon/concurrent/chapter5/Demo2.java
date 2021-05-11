package com.jalon.concurrent.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/5
 */
public class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        for (String a :
                list) {
            if ("b".equals(a)) {
                list.remove(a);
            }
        }
        System.out.println(list);
    }
}
