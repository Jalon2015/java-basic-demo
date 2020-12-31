package com.jalon.java8.lambda;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/14
 */
@FunctionalInterface
public interface FunctionInterfaceDemo {
    void abstractFun();
    default void fun1(){
        System.out.println("fun1");
    }
    default void fun2(){
        System.out.println("fun2");
    }

}
