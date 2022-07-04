package com.jalon.concurrent.chapter5;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  同步容器类：作用
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/5/3
 */
public class SyncCollectionDemo {

    private List<Integer> listNoSync;
    private List<Integer> listSync;

    public SyncCollectionDemo() {
        this.listNoSync = new ArrayList<>();
        this.listSync = Collections.synchronizedList(new ArrayList<>());
    }

    public void addNoSync(int i){
        listNoSync.add(i);
    }

    public void addSync(int j){
        listSync.add(j);
    }

    public static void main(String[] args) throws InterruptedException {
        SyncCollectionDemo demo = new SyncCollectionDemo();

//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                for (int j = 0; j < 1000; j++) {
//                    demo.addNoSync(j);
//                }
//            }).start();
//        }

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    demo.addSync(j);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(demo.listSync.size());
    }
}
