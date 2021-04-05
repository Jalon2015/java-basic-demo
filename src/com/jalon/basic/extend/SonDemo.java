package com.jalon.basic.extend;

import java.util.Objects;

class SonDemo extends Father{
    public SonDemo(){
        super(1);
    }
    // 覆写一：正确示范
    @Override
    public void fun(){
        System.out.println("son fun");
    }
    // 覆写二：错误示范，访问权限低了
//    private void fun(){
//        // 报错：'fun()' in 'SonDemo' clashes with 'fun()' in 'Father'; attempting to assign weaker access privileges ('private'); was 'public'
//        System.out.println("son fun");
//    }

    public static void main(String[] args) {

    }
}

class Father {
    int a;
    public Father(int a){

    }
    private Father(){

    }
    public void fun(){
        System.out.println("father fun");
    }
}
