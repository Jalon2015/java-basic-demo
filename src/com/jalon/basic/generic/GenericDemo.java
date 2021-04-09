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

    // <? super T>为啥可以插入数据
    public static void test4(){
        List<Animal> list = new ArrayList<>();
        list.add(new Cat());

        List<? super Dog> listDog = list;
        listDog.add(new Dog());
//        list.add(new Cat()); // 报错
//        list.add(new Animal()); // 报错
        Dog dog = (Dog) listDog.get(0);
        System.out.println(dog);
    }
    public static void test3(){
        List<? super Dog> list = new ArrayList<Animal>();
        list.add(new Dog());
//        list.add(new Animal());

    }
    public static void test2(){
        List<Dog> listDog = new ArrayList<>();
        listDog.add(new Dog());

        List<? extends Animal> list2 = listDog;
        // 这时如果想往里添加数据，只需要操作listDog即可
        listDog.add(new Dog());
        System.out.println(list2.get(0));

    }
    public static void test1(){
        List<Animal> list = new ArrayList<>();
        list.add(new Cat());
        list.add(new Dog());
        Dog d = (Dog) list.get(0);
        System.out.println(list.get(0));

    }
    public static void main(String[] args) {
        test4();

        Generic2<?> g = new Generic2<>();
        Generic2 g2 = new Generic2();
        System.out.println(g2.getT() == null);
        System.out.println(g.getT() == null);
        dynamicTest();

        // <T>, <? extends T>, <? super T>的区别
        // <T>
//       List<Animal> list = new ArrayList<Dog>();// 报错：需要的是List<Animal>,提供的是ArrayList<Dog>
//       list.add(new Cat()); //这时也会报错
        List<Animal> list1 = new ArrayList<Animal>();// 合法
       list1.add(new Dog());// 合法
        Animal animal = list1.get(0);

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
//        Animal animal = list2.get(0);// 合法，可以查询元素

        // <? super T>
        List<? super Dog> list4 = new ArrayList<Animal>();
        list4.add(new Dog());
//        list4.add(new Animal());
//        list4.add(new Animal());

        // 由于类型擦除（擦除为Object），所以需要强转
        Dog dog2 = (Dog) list4.get(0);

        // <?> 无限定通配符


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
class Generic2<T>{
    private T t;
    public T getT(){
        return t;
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

