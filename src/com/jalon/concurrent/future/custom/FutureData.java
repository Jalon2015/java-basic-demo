package com.jalon.concurrent.future.custom;

/**
 * <p>
 *  FutureData 虚拟数据类，实现了数据接口
 *  该类主要用来包装真实数据
 *  Future的核心就是该类，主线程请求数据时，该类会立即返回；
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/26 16:11
 */
public class FutureData implements Data{

    private RealData realData = null;

    /**
     * 通过setter方法，包装一个真实数据，再通过下面getResult方法来获取
     */
    public void setRealData(RealData realData){
        if(this.realData == null){
            this.realData = realData;
        }
    }

    /**
     * 获取真实数据接口，如果此时真实数据还没处理完成，则需阻塞
     * @return
     */
    @Override
    public String getResult() {
        if (this.realData == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String res = this.realData.getResult();
        this.realData = null;
        return res;
    }
}
