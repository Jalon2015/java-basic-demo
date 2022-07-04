package com.jalon.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * <p>
 *  分而治之，将一个大任务分成多个小任务，充分利用cpu
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/8/31 17:27
 */
public class ForkJoinDemo {
    public static void test1(Long start, Long end){
        long startMillis = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new CountTask(start, end));
        Long sum = null;
        try {
            sum = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("test1 结果为：" + sum);
        System.out.println("test1 耗时："+(System.currentTimeMillis() - startMillis));
    }
    public static void test2(Long start, Long end){
        long startMillis = System.currentTimeMillis();
        long sum = 0;
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("test2 结果为：" + sum);
        System.out.println("test2 耗时："+(System.currentTimeMillis() - startMillis));
    }

    public static void main(String[] args) {
        long start = 1;
        long end = 100000;
        test1(start, end);
        test2(start, end);
    }
}
class CountTask extends RecursiveTask<Long>{

    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        long th = 10000;
        if(end-start<=th){
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        }else{
            long start2 = start;
            ArrayList<CountTask> countTasks = new ArrayList<>();
            for (long i = 0; i <= (end-start)/th; i++) {
                long end2 = start2 + th;
                if(end2 > end){
                    end2 = end;
                }
                CountTask countTask = new CountTask(start2, end2);
                countTasks.add(countTask);
                countTask.fork();
                start2 = end2 + 1;
            }
            for (int i = 0; i < countTasks.size(); i++) {
                sum+=countTasks.get(i).join();
            }
        }
        return sum;
    }
}
