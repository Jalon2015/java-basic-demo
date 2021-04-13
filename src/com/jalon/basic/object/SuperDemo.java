package com.jalon.basic.object;

/**
 * <p>
 *  介绍Super的用法
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/11
 */
public class SuperDemo extends Father{
    public SuperDemo() {
        // 这里显示调用父类的构造函数
        // Super必须放在构造函数的第一行
        super();
        System.out.println("sub construct");
    }

    public static void main(String[] args) {
        SuperDemo demo = new SuperDemo();
        demo.t();
    }

    @Override
    public void t() {
//        System.out.println(1);
//        super.t();
        super.a = 1;

    }
}
class Father{
    public int a;
    public Father() {
        // 这里没有显示调用父类（Object）的构造函数，编译器会自己去调用
        System.out.println("father construct");
    }
    public void t(){

    }
}
