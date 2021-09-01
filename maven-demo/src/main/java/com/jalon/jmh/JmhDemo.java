package com.jalon.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/9/1 12:29
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JmhDemo {

    @Benchmark
    public void test(){
        System.out.println(1);
    }

    public static void main(String[] args) {
        Options build = new OptionsBuilder().include(JmhDemo.class.getSimpleName()).forks(1).build();
        try {
            new Runner(build).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
