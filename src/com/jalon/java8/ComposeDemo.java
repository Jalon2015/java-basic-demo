package com.jalon.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *  复合操作
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/14 18:05
 */
public class ComposeDemo {
    public static void main(String[] args) {
        // 先按年龄排序（默认递增）
        Comparator<Dog> comparableAge = Comparator.comparingInt(Dog::getAge);
        // 如果有相同的年龄，则再按体重排序（如果年龄已经比较出大小，则下面的体重就不会再去比较）
        Comparator<Dog> comparableWeight = Comparator.comparingInt(Dog::getWeight);
        List<Dog> list = Arrays.asList(new Dog(1,2), new Dog(1, 1), new Dog(2,1));
        System.out.println(list);
        list.sort(comparableAge.thenComparing(comparableWeight));
        System.out.println(list);

    }
}

class Dog{
    private int age;
    private int weight;

    public Dog(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", weight=" + weight +
                '}';
    }
}
