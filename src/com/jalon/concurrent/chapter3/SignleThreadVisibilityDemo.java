package com.jalon.concurrent.chapter3;

/**
 * <p>
 *  可见性
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/27
 */
public class SignleThreadVisibilityDemo {
    // 共享变量
    private int number;
    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber(){
        return this.number;
    }
    public static void main(String[] args) {
        SignleThreadVisibilityDemo demo = new SignleThreadVisibilityDemo();
        System.out.println(demo.getNumber());
        demo.setNumber(10);
        System.out.println(demo.getNumber());
    }
}
