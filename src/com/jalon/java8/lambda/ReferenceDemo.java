package com.jalon.java8.lambda;

/**
 * <p>
 *  方法引用，构造函数引用
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/14 17:48
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        Cat cat = new Cat(10);
    }
}
class Cat {
    int age;

    public Cat() {
    }

    public Cat(int age) {
        this.age = age;
    }
}
