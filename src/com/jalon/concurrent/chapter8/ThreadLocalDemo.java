package com.jalon.concurrent.chapter8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *  ThreadLocal：翻译为 线程本地变量 比较贴切，它和普通变量不一样，它外表是一个全局变量，但是内心却是局部变量，为线程所独有
 *  作用：线程之间的数据隔离（局部变量的好处）， 方便多个方法之间的传参（全局变量的好处），取长补短
 *  缺点：内存泄漏（类似之前介绍的显式锁，如果忘记释放锁，也是会导致各种问题）
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/5/27 11:11
 */
public class ThreadLocalDemo {

    // 线程不安全：在多个线程中执行时，有可能解析出错
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void parse(String dateString){
        try {
            System.out.println(simpleDateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // 线程安全1：加内置锁
    private SimpleDateFormat simpleDateFormatSync = new SimpleDateFormat("yyyy-MM-dd");
    public void parse1(String dateString){
        try {
           synchronized (simpleDateFormatSync){
               System.out.println(simpleDateFormatSync.parse(dateString));
           }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // 线程安全2：用ThreadLocal创建对象副本，做数据隔离
    // 下面这个代码可以简化，通过 withInitialValue
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        // 初始化方法，每个线程只执行一次；比如线程池有10个线程，那么不管运行多少次，总的SimpleDateFormat副本只有10个
        @Override
        protected SimpleDateFormat initialValue() {
            // 这里会输出10次，分别是每个线程的id
            System.out.println(Thread.currentThread().getId());
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    public void parse2(String dateString){
        try {
            System.out.println(threadLocal.get().parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadLocalDemo demo = new ThreadLocalDemo();
        for (int i = 0; i < 30; i++) {
            service.execute(()->{
                demo.parse2("2020-01-01");
            });
        }
    }
}
