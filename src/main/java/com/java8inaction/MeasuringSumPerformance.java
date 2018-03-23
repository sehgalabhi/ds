package com.java8inaction;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MeasuringSumPerformance {
    public static void main(String[] args) {
        new MeasuringSumPerformance().test();

    }

    private void test() {
//        System.out.println("Sequential sum done in " + measure(this::sequentialSum, 10_000_000) + "msecs");
//        System.out.println("Iterative sum done in " + measure(this::iterativeSum, 10_000_000) + "msecs");
//        System.out.println("Parallel sum done in " + measure(this::parallelSum, 10_000_000) + "msecs");
        System.out.println("Ranged sum done in " + measure(this::rangedSum, 10_000_000) + "msecs");
        System.out.println("Ranged parallelsum done in " + measure(this::rangedParallelSum, 10_000_000) + "msecs");

    }

    private long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).collect(Collectors.reducing(0L, Long::sum));
    }

    private long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    private long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().collect(Collectors.reducing(0L, Long::sum));
    }

    private long rangedSum(long n){
        return LongStream.rangeClosed(1,n).reduce(0L, Long::sum);
    }

    private long rangedParallelSum(long n){
        return LongStream.rangeClosed(1,n).parallel().reduce(0L, Long::sum);
    }

    public static long measure(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i <= 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start)/1_000_000;
            System.out.println("Result : "+ sum);
            if(duration < fastest){
                fastest = duration;
            }
        }
        return fastest;
    }


}
