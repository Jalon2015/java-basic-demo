package com.jalon.basic.io;

import java.io.*;
import java.util.UUID;

/**
 * <p>
 *  对象IO：基于对象的存储和读取，对象类必须序列化
 *  用到的类：ObjectInputStream，ObjectOutputStream
 * </p>
 *
 * @author: jalon2015
 * @date: 2021/3/29 11:42
 */
public class ObjectIoDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InnerObject object1 = new InnerObject(10);
        String filename = "object.bin";
        writeObjectFun(filename, object1);
        InnerObject objectReturn = (InnerObject) readObjectFun(filename);
        System.out.println(objectReturn);

    }

    // 写对象 到指定文件
    public static void writeObjectFun(String filename, Object o) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        // 关闭流，fileOutputStream会一并关闭
        objectOutputStream.close();
    }

    // 读对象 从指定文件
    public static Object readObjectFun(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        // 关闭流，fileInputStream会一并关闭
        objectInputStream.close();
        return o;
    }
}
class InnerObject implements Serializable{

    @Override
    public String toString() {
        return "InnerObject{" +
                "num=" + num +
                '}';
    }

    public InnerObject(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;
}
