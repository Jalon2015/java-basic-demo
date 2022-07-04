package com.jalon.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        // 需求：筛选年龄大于1的，并排序,最后将名字存放起来
        List<Cat> list = Arrays.asList(new Cat(1, "tangyuan"), new Cat(3, "dangdang"), new Cat(2, "milu"));
        // === 旧代码 Java8之前 ===
        List<Cat> listTemp = new ArrayList<>();
        // 1. 筛选
        for(Cat cat: list){
            if(cat.getAge()>1){
                listTemp.add(cat);
            }
        }
        // 2. 排序
        listTemp.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                // 递增排序
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        // 3. 提取名字
        List<String> listName = new ArrayList<>();
        for(Cat cat: listTemp){
            listName.add(cat.getName());
        }
        System.out.println(listName);

        // === 新代码 Java8之后 ===
        List<String> listNameNew = list.stream()
                .filter(cat -> cat.getAge() > 1)
                .sorted(Comparator.comparingInt(Cat::getAge))
                .map(cat-> cat.getName())
                .collect(Collectors.toList());

        System.out.println(listNameNew);

        // 流式操作会自动合并操作，比如下面的filter
        // 这里可以对照下前面lambda的组合操作（乍一看，有点像，实际上还是有区别的）
        // 1. 流操作不是一开始就执行，而是等到所有的中间操作都加载完，并执行终端操作时，才会开始执行
        // 而且不是按照链接的顺序执行，而是多个操作组合到一起执行，比如下面的filter和map和limit会组合执行，而不是先filter再map
        // 正是由于由于这个原因，所以当filter中有一个满足的元素时，流就会停止，并直接跳到最后一步的终端操作

        printSth();
        System.out.println("limit");
        limitFun();
    }

    public static void printSth(){
        List<Cat> list = Arrays.asList(new Cat(1, "tangyuan"), new Cat(3, "dangdang"), new Cat(2, "milu"));
        List<String> listNameNew = list.stream()
                .filter(cat -> {
                    System.out.println("filter: " + cat);
                    return cat.getAge() > 1;
                })
                .map(cat-> {
                    System.out.println("map:" + cat);
                    return cat.getName();
                })
                .collect(Collectors.toList());
    }
    // 短路技巧
    public static void limitFun(){
        List<Cat> list = Arrays.asList(new Cat(1, "tangyuan"), new Cat(3, "dangdang"), new Cat(2, "milu"));
        List<String> listNameNew = list.stream()
                .filter(cat -> {
                    System.out.println("filter: " + cat);
                    return cat.getAge() > 1;
                })
                .map(cat-> {
                    System.out.println("map:" + cat);
                    return cat.getName();
                })
                .limit(1)
                .collect(Collectors.toList());
    }
}
class Cat {
    int age;
    String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
