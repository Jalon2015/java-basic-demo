package com.jalon.java8.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p>
 *  Optional：包装null，解决NPE问题
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/18
 */
public class OptionalDemo {
    private static final String DEFAULT_NAME = "javalover";

    public static void main(String[] args) {
//        getName(null);
        getName2(null);

    }
    // 取出c.name
    public static void getName(C c){
        // 旧代码
        String name = (c!=null ? c.getName() : DEFAULT_NAME);
        System.out.println("old: "+name);
        // 新代码
        String nameNew = Optional
                            .ofNullable(c)
                            .map(c1->c1.getName())
                            .orElse(DEFAULT_NAME);

        System.out.println("new: "+nameNew);
    }

    // 取出 b.c.name
    public static void getName2(B b){
        // 旧代码
        String name = b!=null ? ( b.getC()!=null ? b.getC().getName() : DEFAULT_NAME) : DEFAULT_NAME;
        // 新代码
        String nameNew = Optional
                .ofNullable(b)
                .map(b1->b1.getC())
                .map(c1->c1.getName())
                .orElse(DEFAULT_NAME);
        System.out.println(nameNew);
    }
}
class A{
    private B b;

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
class B{
    private C c;

    public B(C c) {
        this.c = c;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
class C{
    private String name;

    public C(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}