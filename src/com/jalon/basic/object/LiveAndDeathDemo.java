package com.jalon.basic.object;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/11
 */
public class LiveAndDeathDemo {
    private int a=2;
    private String name;
    public static void main(String[] args) {
        LiveAndDeathDemo live = new LiveAndDeathDemo();
        live.fun();
    }
    public void fun(){
        int temp = 10;
        System.out.println(temp);
    }
    public LiveAndDeathDemo(){
        this(1);
    }
    public LiveAndDeathDemo(int a) {
        this(a, "JavaLover");
    }
    public LiveAndDeathDemo(int a, String name) {
        this.a = a;
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
