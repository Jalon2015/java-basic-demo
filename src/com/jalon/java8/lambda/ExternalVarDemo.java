package com.jalon.java8.lambda;

/**
 * <p>
 *  lambda引用外部变量的限制
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/15
 */
public class ExternalVarDemo {
    public static void main(String[] args) {
        String str = "javalover.cc";
        Runnable runnable = ()->{
            System.out.println(str);
        };
    }
}
