package com.jalon.java8.optional;

import java.util.Optional;

/**
 * <p>
 *  Optional：包装null，解决NPE问题
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/18
 */
public class OptionalDemo {
    // 1. 包装现有库的null返回值，比如Map
    public static void nullFun(){
        Optional<Cat> optional = Optional.of(new Cat(1));
        optional.isPresent(c-> System.out.println(c));
    }
}
class Cat{
    int age;

    public Cat(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
