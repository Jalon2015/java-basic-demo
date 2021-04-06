package com.jalon.basic.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  泛型
 * </p>
 *
 * @author: JavaLover
 * @Time: 2021-04-05 18:39
 **/
public class GenericDemo {
    public static void main(String[] args) {
        dynamicTest();
        // <T>, <? extends T>, <? super T>的区别
        // <T>
//       List<Animal> list = new ArrayList<Dog>();// 报错：需要的是List<Animal>,提供的是ArrayList<Dog>
       List<Animal> list1 = new ArrayList<Animal>();// 合法
       list1.add(new Dog());// 合法
//        List<Animal> list = new ArrayList<>();
        List<Cat> listCat = new ArrayList<>();

//        addAnimal(list, new Animal());
        addAnimal(listCat, new Cat());

       // <? extends T>
       List<? extends Animal> list2 = new ArrayList<Dog>();// 正确
//        list2.add(new Dog()); // 报错：不能往里添加元素
        // 由于类型擦除（擦除到`? extends Animal`的上界），所以需要强转
        Dog dog = (Dog) list2.get(0); // 合法，可以查询元素
        // 不需要强转
        Animal animal = list2.get(0);// 合法，可以查询元素

        // <? super T>
        List<? super Dog> list4 = new ArrayList<>();
        list4.add(new Dog());
        // 由于类型擦除（擦除为Object），所以需要强转
        Dog dog2 = (Dog) list4.get(0);

    }
    public static <T> void addAnimal(List<T> list, T animal){
        list.add(animal);
    }

    // 动态类型安全检查，在与旧代码兼容时，防止将Dog放到Cat集合中
    public static void dynamicTest(){
        // 没检查之前
        List list = new ArrayList<Integer>();
        // 添加不报错
        list.add("a");
        list.add(1);
        // 只有用的时候，才会报错
//        Integer i = (Integer) list.get(0);
        System.out.println(list);

        // 检查之后
        List list2 = Collections.checkedList(new ArrayList<>(), Integer.class);
        // 插入时就会报错
        list2.add("a");
        list2.add(1);
        // 只有用的时候，才会报错
        Integer i2 = (Integer) list.get(0);
        System.out.println(list2);


    }
}

class Animal{

}
class Cat extends Animal{
    public void jump(){

    }
}
class Dog extends Animal{

}

