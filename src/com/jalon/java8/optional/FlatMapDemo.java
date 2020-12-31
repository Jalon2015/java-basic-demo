package com.jalon.java8.optional;

import java.util.Optional;
import java.util.function.Function;

/**
 * <p>
 *  flatMap：扁平化处理
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/18
 */
public class FlatMapDemo {
    private static final String DEFAULT_NAME = "javalover";

    public static void main(String[] args) {
        getName(null);
    }

    // 取出 b.c.name
    public static void getName(B2 b){
        C c = Optional
                .ofNullable(b)
                .flatMap(b2->b2.getC())
                .orElse(new C("xxx"));
        System.out.println(c.getName());
    }
}

class B2{
    private Optional<C> c;

    public Optional<C> getC() {
        return c;
    }

    public void setC(C c) {
        this.c = Optional.ofNullable(c);
    }
}

class C2{
    private String name;

    public C2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}