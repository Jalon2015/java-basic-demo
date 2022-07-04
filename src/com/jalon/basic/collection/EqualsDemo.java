package com.jalon.basic.collection;

import java.util.Objects;

/**
 * <p>
 *  equals方法的介绍
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/9 15:12
 */
public class EqualsDemo {
    private int m;
    private String str;

    public static void main(String[] args) {
        EqualsDemo demo1 = new EqualsDemo(1, null);
        EqualsDemo demo2 = new EqualsDemo(1, "JavaLover1");
        System.out.println(demo1.equals(demo2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        EqualsDemo demo = (EqualsDemo) o;
        return m == demo.m && Objects.equals(str,demo.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, str);
    }

    public EqualsDemo(int m, String str) {
        this.m = m;
        this.str = str;
    }




    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
class B1 extends EqualsDemo{
    private int b;
    public B1(int m, String str) {
        super(m, str);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        B1 b1 = (B1) o;
        return b == b1.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), b);
    }

    public B1(int m, String str, int b) {
        super(m, str);
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
