package com.jalon.basic.primitive;

/**
 * <p>
 *
 * </p>
 *
 * @author: jalon2015
 * @date: 2021/3/29 17:44
 */
public class PrimitiveDemo {
    public static void main(String[] args) {
        ObjectTest object1 = new ObjectTest();
        ObjectTest object2 = new ObjectTest();
        ObjectTest object3 = object2;
        System.out.println(object3);
        object2 = object1;
        System.out.println(object3);
    }

}
class ObjectTest{

}
