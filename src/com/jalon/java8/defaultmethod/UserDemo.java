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
        /**you
         *  InterfaceDemo升级后，新增了newFun方法
         *  但是由于newFun是默认方法，有提供实现内容
         *  所以这里的子类 UserDemo就可以直接使用
          */
        demo.newFun();
    }
}
