package com.jalon.java8.defaultmethod;

/**
 * <p>
 *  接口类，这里假设是一个类库
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/13
 */
public interface InterfaceDemo {
    int a = 0;
    void oldFun();
    default void newFun(){
        System.out.println("newFun");
    }
}
