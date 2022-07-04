package com.jalon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/3 16:12
 */
public class MapDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<>(7);
        // 1-1，2-2，3-4，4-4
//        map.put("name", "javalover");
        Class<? extends Map> aClass = map.getClass();
        Method capacity = aClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println(capacity.invoke(map));
        System.out.println(map.size());
        for (int i = 0; i < 12; i++) {
            map.put(Integer.valueOf(i).toString(), "");
        }
        System.out.println(capacity.invoke(map));
        System.out.println(map.size());
    }
}
