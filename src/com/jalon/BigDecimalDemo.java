package com.jalon;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  BigDecimal相关知识点：
 *      1. 禁止用equals比较两个BigDecimal对象：因为equals比较值的同时，还会比较标度scale，建议用compareTo比较值
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/3 11:32
 */
public class BigDecimalDemo {

    static void test1(){
        Map<String, Boolean> map = new HashMap<>();
        Boolean b = (map!=null)?map.get("name"):false;
        System.out.println(b);
    }

    public static void main(String[] args) {
        test1();
        BigDecimal bigDecimal1 = new BigDecimal(1);
        BigDecimal bigDecimal2 = new BigDecimal(1.0);
        BigDecimal bigDecimal3 = new BigDecimal(1.0);
        BigDecimal bigDecimal4 = new BigDecimal(1.00);
        BigDecimal bigDecimal5 = new BigDecimal(0.1);
        BigDecimal bigDecimal6 = new BigDecimal(0.10);
        System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal3.equals(bigDecimal4));
        System.out.println(bigDecimal5.equals(bigDecimal6));

        BigDecimal bigDecimal7 = new BigDecimal("1.0");
        BigDecimal bigDecimal8 = new BigDecimal("1.00");
        System.out.println(bigDecimal7.equals(bigDecimal8));

        System.out.println(bigDecimal7.compareTo(bigDecimal8));
    }
}
