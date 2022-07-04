package com.jalon.concurrent.future.custom;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  主程序，这个包custom内部是自己写的一个模仿Future的例子
 *  核心就是：当请求执行一个将耗时操作时，将该操作单独开启一个线程执行，然后请求的线程就可以立即返回
 *  这里面涉及到两个数据：
 *      1. 一个虚拟数据（立即返回的数据，即FutureData）
 *      2. 一个真实数据（单独开启的线程执行的任务，执行完后返回的数据，即RealData）
 * </p>
 * 工厂方法就是所谓的静态方法
 * @author: JavaLover
 * @date: 2021/8/26 16:14
 */
public class MainDemo {
    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("发送请求");
        Data data = client.request(3);
        System.out.println("立即返回结果");
        System.out.println("执行其他任务，耗时1S");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始获取第一个任务的真实结果：");
        String result = data.getResult();
        System.out.println(result);
    }
}
