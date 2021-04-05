package com.jalon.basic.extend;

/**
 * 多态的应用
 */
public class PolyphorismDemo {
    public static void main(String[] args) {
        PolyphorismDemo demo = new PolyphorismDemo();
        //场景一：形参，将猫（子类）赋值给动物（父类）
        demo.fun(new Cat());
        //场景二：返回值，将猫赋值给动物
        Animal animal = demo.fun2();
    }

    public void fun(Animal animal){

    }

    public Animal fun2(){
        return new Cat();
    }
}

class Animal{

}

class Cat extends Animal{

}