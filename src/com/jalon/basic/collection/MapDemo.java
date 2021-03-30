package com.jalon.basic.collection;

import java.util.HashMap;
import java.util.Map;

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
        // 键值对集合，键不可以重复，值可以重复
        Map<String, Integer> map = new HashMap<>();
        // 添加 put
        // 首先会检查对应的key是否存在，如果不存在，则新建键值对，然后填充；如果存在，则覆盖已有的值
        System.out.println(map.put("hello", 1)); // 这里的 1 会自动装箱为 Integer 对象
        System.out.println(map.put("hello", 2)); // 这里的 1 会自动装箱为 Integer 对象
        // 查询
    }
}
