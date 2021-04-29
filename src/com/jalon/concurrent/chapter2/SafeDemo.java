package com.jalon.concurrent.chapter2;

/**
 * <p>
 *  线程安全的类：无状态
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/24
 */
public class SafeDemo {

    // 没有可变状态
    // 没有共享状态

    public int sum(int n, int m){
        return n + m;
    }

    public static void main(String[] args) {
        SafeDemo safeDemo = new SafeDemo();
        for (int i = 0;i<10000;i++){
            // 只有两个局部变量 n, m
            // 至于为啥在这里重新定义两个局部变量，这个涉及到java8中新出的 effectively final 定义
            int n = i;
            int m = i;
            new Thread(()->{
                int sum = safeDemo.sum(n, m);
                // 你会发现，不管多少个线程一起运行，肯定是n==m
                if(n!=m){
                    System.out.println(n+" + "+m + " = " + sum);
                }
            }).start();
        }
    }
}
