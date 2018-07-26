package com.java8inaction.streams.parallel;

import com.java8inaction.streams.forkjoin.ForkJoinTest;

import java.util.function.Function;

public class MesaurePerformance {

    public static void main(String[] args) {
        new MesaurePerformance().test();
    }

    private void test() {
        long sequentialSum = measureSumPerformance(SumStreams::sequentialPrimitiveStreamsSum, 10_000_000);
        System.out.println(sequentialSum);
        long parallelSum = measureSumPerformance(SumStreams::parallelPrimitiveSTreamsSum, 10_000_000);
        System.out.println(parallelSum);

        long sequentialNonPrimitiveStreamsSum = measureSumPerformance(SumStreams::sequentialNonPrimitiveStreamsSum, 10_000_000);
        System.out.println(sequentialNonPrimitiveStreamsSum);
        long parallelNonPrimitiveSTreamsSum = measureSumPerformance(SumStreams::parallelNonPrimitiveSTreamsSum, 10_000_000);
        System.out.println(parallelNonPrimitiveSTreamsSum);

        long forkJoin = measureSumPerformance(ForkJoinTest::test, 10_000_000);
        System.out.println(forkJoin);
    }

    private long measureSumPerformance(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();

            Long sum = adder.apply(n);

            long end = System.nanoTime();
            long duration = (end - start) /1_000_000;
            if (duration < fastest)
                fastest = duration;
        }
        return fastest;

    }
}
