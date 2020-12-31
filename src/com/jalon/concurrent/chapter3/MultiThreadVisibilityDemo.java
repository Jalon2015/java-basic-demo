package com.jalon.concurrent.chapter3;

/**
 * <p>
 *  可见性:多线程的可见性问题
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/27
 */
public class MultiThreadVisibilityDemo {
    // 共享变量
    private volatile int number;
    public static void main(String[] args) throws InterruptedException {
        MultiThreadVisibilityDemo demo = new MultiThreadVisibilityDemo();
        new Thread(()->{
            while (0==demo.number);
            System.out.println(demo.number);
        }).start();
        Thread.sleep(1000);
        // 168不是身高，只是个比较吉利的数字
        demo.setNumber(168);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
