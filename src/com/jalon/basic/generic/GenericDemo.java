package com.jalon.basic.generic;

import java.util.ArrayList;
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
        List<Dog> list2 = new ArrayList<>();

    }
}
class Animal{
    public void fun(){

    }
}
class Dog extends Animal{
    public <T> void fun(T t){
        t.compareTo();
    }
}
