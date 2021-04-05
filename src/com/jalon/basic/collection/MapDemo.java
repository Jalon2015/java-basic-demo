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
public class MapDemo {
    public static void main(String[] args) {
//        // 键值对集合，键不可以重复
        Map<String, Integer> map = new HashMap<>();
        // 添加：首先会检查对应的key是否存在，如果不存在，则新建键值对，然后填充；如果存在，则覆盖已有的值
        map.put("a", 10); // 这里的1会自动装箱为Intege类型
        map.put("b", 20); // 这里的1会自动装箱为Intege类型
        map.put("c", 30); // 这里的1会自动装箱为Intege类型

        Set<String> set = map.keySet();
        set.add("a");
//        // 连续插入100个数
//        int i =100;
//        while (i-->0){
//            map.put(""+i, i);
//        }
//        // 查询
//        for (String str :
//                map.keySet()) {
//            // 这里会乱序输出
//            System.out.println(str);
//        }
        // TreeMap
//        Map<String, Integer> map1 = new TreeMap<>();
//        // 连续倒序插入100个数
//        int k =100;
//        while (k-->0){
//            map1.put(""+k, k);
//        }
//        // 查询
//        for (String str :
//                map1.keySet()) {
//            // 这里会正序输出
//            System.out.println(str);
//        }
//

        Map<A, Integer> map3 = new TreeMap<>();
        map3.put(new A(), 1);
        map3.put(new A(), 2);
        map3.put(new A(), 3);
        System.out.println(map3);

        // LinkedHashMap
//        Map<String, Integer> map2 = new LinkedHashMap<>();
//        // 倒序插入100个数
//        int j =100;
//        while (j-->0){
//            map2.put(j+"", j);
//        }
//        for (String str :
//                map2.keySet()) {
//            // 这里按照插入的顺序依次输出
//            System.out.println(str);
//        }

    }
}
class A{

}
