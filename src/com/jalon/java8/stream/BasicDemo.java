package com.jalon.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 *  流的入门操作
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/16 10:39
 */
public class BasicDemo {
    public static void main(String[] args) {
        List<Cat> list = Arrays.asList(new Cat(1), new Cat(2), new Cat(3));
        // 流式操作会自动合并操作，比如下面的filter
        // 这里可以对照下前面lambda的组合操作（乍一看，有点像，实际上还是有区别的）
        // 1. 流操作不是一开始就执行，而是等到所有的中间操作都加载完，并执行终端操作时，才会开始执行
        // 而且不是按照链接的顺序执行，而是多个操作组合到一起执行，比如下面的filter和map和limit会组合执行，而不是先filter再map
        // 正是由于由于这个原因，所以当filter中有一个满足的元素时，流就会停止，并直接跳到最后一步的终端操作
        // 2.
        List<Integer> collect = list.stream()
                .filter(cat -> {
                    System.out.println("filter: " + cat);
                    return cat.getAge() > 1;
                })
                .map(cat->{
                    System.out.println("map: " + cat);
                    return cat.getAge();
                })
                .collect(Collectors.toList());

        System.out.println(collect);
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

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
