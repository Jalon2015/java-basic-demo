package com.jalon.java8.defaultmethod;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/14 10:59
 */
public class A implements B,C{

    @Override
    public void fun(){
        // 显示调用B的默认方法
        B.super.fun();
    }

    public static void main(String[] args) {
        A a = new A();
        a.fun();
    }
}
interface D{
    default void fun(){
        System.out.println("D");
    }
}
interface B extends D{
    @Override
    default void fun(){
        System.out.println("B");
    }
}
interface C extends D{
    @Override
    default void fun(){
        System.out.println("C");
    }
}

