package com.jalon.jvm.chapter1;

import java.util.ArrayList;

/**
 * <p>
 *  内存溢出 实战
 *  VM: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError (设置堆的上下限为20m，设置OOM时导出快照）
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/6/23 15:59
 */
public class OOMDemo {

    public static void main(String[] args) {
        ArrayList<OOMDemo> oomDemos = new ArrayList<>();
        while (true){
            oomDemos.add(new OOMDemo());
        }
    }
}
