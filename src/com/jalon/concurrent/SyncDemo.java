package com.jalon.concurrent;

/**
 * <p>
 *  同步demo
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/24
 */
public class SyncDemo {

    public static void main(String[] args) {
        // 此时father对象就是那个锁
        Father father = new Son();
        // 不管哪个线程来访问fun方法，都要先获取father锁
        father.fun();
    }
}
class Father{
    public synchronized void fun(){
        System.out.println("father fun");
    }
}
class Son extends Father{
    @Override
    public synchronized void fun() {
        System.out.println("son fun");
        super.fun();
    }
}
