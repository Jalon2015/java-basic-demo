package com.jalon.concurrent.future.custom;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  真实数据，被包装在虚拟数据中，包装的过程是在单独线程中执行的，这样调用方才可以立即返回数据，不会被阻塞
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/26 16:16
 */
public class RealData implements Data {
    private String res;

    /**
     * 构造函数,通过sleep模拟耗时操作
     * @param n
     */
    public RealData(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append("sleep ");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.res = stringBuffer.toString();
    }

    @Override
    public String getResult() {
        return this.res;
    }
}
