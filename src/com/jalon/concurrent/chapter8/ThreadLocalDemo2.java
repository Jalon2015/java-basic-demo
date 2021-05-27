package com.jalon.concurrent.chapter8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *  ThreadLocal：应用场景2，全局变量的好处
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/5/27 11:11
 */
public class ThreadLocalDemo2 {

    // 参数传递，程序繁琐
    public void fun1(int age){
        System.out.println(age);
        fun2(age);
    }
    private void fun2(int age){
        System.out.println(age);
        fun3(age);
    }
    private void fun3(int age){
        System.out.println(age);
    }

    // 简化，ThreadLocal当全局变量来使用
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<Integer>();

    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<Integer>();

    public void t(){
        threadLocal1.set(1);
        threadLocal2.set(2);
        System.out.println(threadLocal1.get());
        System.out.println(threadLocal2.get());
    }

    public void fun11(){
        System.out.println(threadLocal.get());
        fun22();
    }
    private void fun22(){
        System.out.println(threadLocal.get());
        fun33();
    }
    private void fun33(){
        int age = threadLocal.get();
        System.out.println(age);
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadLocalDemo2 demo = new ThreadLocalDemo2();
        demo.t();
//        for (int i = 0; i < 30; i++) {
//            final int j = i;
//            service.execute(()->{
//                try{
//                    threadLocal.set(j);
//                    demo.fun11();
//                }finally {
//                    threadLocal.remove();
//                }
//            });
//        }
    }
}
