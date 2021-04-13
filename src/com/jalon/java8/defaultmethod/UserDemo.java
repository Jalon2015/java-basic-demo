package com.jalon.java8.defaultmethod;

/**
 * <p>
 *  用户类：这里模拟普通用户类，实现了类库的接口
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/13
 */
public class UserDemo implements InterfaceDemo{
    @Override
    public void oldFun() {
        System.out.println("oldFun");
    }

    public static void main(String[] args) {
        UserDemo demo = new UserDemo();
        demo.newFun();
    }
}
