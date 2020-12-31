package com.jalon.concurrent.chapter5;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  及时失败：并发修改异常
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/4
 */
public class ConcurrentExceptionDemo {

    List<Apple> list;
    List<Apple> listVector;

    public ConcurrentExceptionDemo(List<Apple> list1, List<Apple> list2) {
        list = list1;
        listVector = list2;
    }

    public void vectorFun(){
        for (Apple o :
                listVector) {
            listVector.remove(o);
        }
        System.out.println(listVector);
    }

    public void collectionsFun(){

        for (Apple o :
                list) {
            list.remove(o);
        }
        System.out.println(list);
    }


    public static void main(String[] args) throws InterruptedException {
        List<Apple> list = Collections.synchronizedList(new ArrayList<>());
//        List<Apple> list = new Vector<>(new ArrayList<>());
        list.addAll(Arrays.asList(new Apple(1), new Apple(2), new Apple(3)));
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                Iterator iterator = list.iterator();
                while (iterator.hasNext()){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=>" + iterator.next());
                }
            }).start();
        }

        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                Iterator iterator = list.iterator();
                while (iterator.hasNext()){
                    System.out.println(Thread.currentThread().getName() + "=>" + iterator.next());
                    iterator.remove();
                }
            }).start();
        }


//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(list);
    }
}
class Apple{
    private int weight;

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}