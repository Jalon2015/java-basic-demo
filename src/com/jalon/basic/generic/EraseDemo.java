package com.jalon.basic.generic;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/6 15:34
 */
public class EraseDemo<T> {

    public static void main(String[] args) {
        EraseDemo<Father> eraseDemo = new EraseDemo<>();
        eraseDemo.eraseFun1(new Father());
    }
    public void eraseFun1(T t){

        //        t.fun(); // 报错：由于编译器执行了类型擦除，所以这里的t被当作Object对象来看待
    }
    // 这样就不报错了
    public <S extends Father> void eraseFun2(S s){
        s.fun();
    }
}
class Father{
    public void fun(){

    }
}
class Son extends Father{
    @Override
    public void fun(){

    }
}
