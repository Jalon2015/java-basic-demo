package com.jalon.java8.lambda;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;

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
        // 1. 方法引用
        // 第一种:引用对象的实例方法
        Cat cat = new Cat(1);
        Function<Cat, Integer> methodRef1 = cat::getSum;
        // 第二种:引用类的静态方法
        Supplier<Integer> methodRef2 = Cat::getAverageAge;
        // 第三种：引用类的实例方法
        Function<Cat, Integer> methodRef3 = Cat::getAge;

        // 2. 构造引用
        // 这里调用 new Cat()
        Supplier<Cat> constructRef1 = Cat::new;
        // 这里调用 new Cat(Integer)
        Function<Integer, Cat> constructRef2 = Cat::new;

    }
}
class Cat {
    int age;
    public Cat(){}
    public Cat(int age) {
        this.age = age;
    }

    // 获取猫的平均年龄
    public static int getAverageAge(){
        return 15;
    }
    // 获取两只猫的年龄总和
    public int getSum(Cat cat){
        return cat.getAge() + this.getAge();
    }

    public int getAge() {
        return age;
    }    public void setAge(int age) {
        this.age = age;
    }
}
