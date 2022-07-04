package com.jalon.basic.generic;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/8 11:01
 */
public class BridgeDemo<T> extends A<T> {
    @Override
    public void compare(T t) {
        super.compare(t);
    }

    public static void main(String[] args) {
        BridgeDemo<String> b = new BridgeDemo<>();
        b.compare("hello");
    }
}

class A<T>{
    private T t;
    public void compare(T t){

    }
}