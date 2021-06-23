package com.jalon.jvm.chapter1;

/**
 * <p>
 *  栈内存溢出
 *  VM: -Xss128k 设置栈内存128k
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/6/23 16:37
 */
public class OOMDemo2 {
    private static int count = 0;
    public static void test(){
        count++;
        test();
    }
    public static void main(String[] args) {
        try {
            test();
        }catch (Throwable e){
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
