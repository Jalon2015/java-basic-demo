package com.jalon.concurrent.future.custom;

/**
 * <p>
 *  客户端，负责发送请求，即调用方
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/26 16:14
 */
public class Client {
    public Data request(Integer param){
        FutureData futureData = new FutureData();
        new Thread(()->{
            RealData realData = new RealData(param);
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}
