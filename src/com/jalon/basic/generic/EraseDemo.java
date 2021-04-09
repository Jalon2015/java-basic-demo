package com.jalon.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  类型擦除
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/6 15:34
 */
public class EraseDemo<T> {
    private T t;
    public static void main(String[] args) {
//        List<Father> list1 = new ArrayList<Son>();
        // Son继承Father，但是没有泛型
        Father<String> father = new Father<>();
        System.out.println(father.getClass());
//        ArrayList<String> list = new ArrayList();
//        list.add("a");
//        ArrayList<String> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        System.out.println(list1.getClass() == list2.getClass());
//
//        // 桥方法
//        NumericValue numericValue = new NumericValue();
//        numericValue.compareTo(new NumericValue());
//        EraseDemo<Father> eraseDemo = new EraseDemo<>();
//        // 编译器的类型擦除与类型自动转换
//        // 添加泛型类型T的实际类型Father的一个对象（这里可以把类型参数T看作形参，实际类型参数Father看作实参）
//        // 添加之后，编译器会进行类型擦除，这里因为没有类型限定（如果是<T extends Father>，所以擦除为Object
//        eraseDemo.setT(new Father());
//        // 下面紧接着获取刚才插入进去的对象
//        // 你会发现，你不需要强转Object->Father，因为编译器内部自动做了强制类型转换（在你获取泛型对象时）
//        // 你可以把下面这条语句拆开来理解
//        // 语句1：Object o = eraseDemo.getT();
//        // 语句2：Father t = (Father)o;
//        Father f = eraseDemo.getT();
//
//
////        eraseDemo.eraseFun1(new Father());
////        eraseDemo.eraseFun2(new Father());
//        List<Father> list = new ArrayList<>();
//        System.out.println(list);
    }
    public T getT(){
        return t;
    }
    public void setT(T t){
        // 这里无法调用t.fun，因为这里t被擦除为Object；不过可以通过设置边界来处理
        // 其实这里的擦除还是比较合理的，因为在编写这个方法时，你也不知道T是啥类型，所以只能按Object基类型来处理
        // 反过来，
        // 假设这里可以调用t.fun，那也会显得很奇怪
        // 因为这个类相当于是先定义的，而你给T赋值在这个之后
        // 再假设这里可以调用t.fun，那如果后面再传来一个其他类呢？这里岂不是也要调用其他类的某些方法吗？那就很乱了
        this.t = t;
    }
//    public void eraseFun1(T t){
//        System.out.println(t.getClass());
//        //        t.fun(); // 报错：由于编译器执行了类型擦除，所以这里的t被当作Object对象来看待
//    }
//    // 这样就不报错了
//    public <S extends Father> void eraseFun2(S s){
//        s.fun();
//    }
}
class Father<T>{
    private T t;
    public void fun(T t){
        Class c = t.getClass();
        System.out.println(c);
        this.t = t;
    }
    public Class get(){
        Class c = t.getClass();
        System.out.println(c);
        return c;
    }
}
class Son extends Father{
}
class NumericValue implements Comparable<NumericValue>{
    @Override
    public int compareTo(NumericValue o) {
        return 0;
    }
}
