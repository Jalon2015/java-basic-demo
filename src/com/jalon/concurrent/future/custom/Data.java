package com.jalon.concurrent.future.custom;

/**
 * <p>
 *  数据接口，实现类有虚拟数据 FutureData 和真实数据 RealData
 *  Future模式就是调用时，立即返回虚拟数据，然后后台再去慢慢执行请求的任务，生成真实数据
 *  这样主线程就可以继续去处理其他的任务，而不会被阻塞
 *  如果后面主线程想要获取真实数据，可通过该数据接口中的getResult方法来获取，该方法在虚拟数据中有实现方法；
 *  如果此时真实数据还没生成，那么主线程就会被阻塞，直到真实数据生成
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/26 16:04
 */
public interface Data {
    /**
     * 获取 Future 的结果
     * @return
     */
    public String getResult();
}
