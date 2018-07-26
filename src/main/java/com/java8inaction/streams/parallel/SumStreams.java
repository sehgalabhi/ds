package com.java8inaction.streams.parallel;

import java.util.stream.LongStream;

public class SumStreams {

    public static long sequentialPrimitiveStreamsSum(long n) {
        return LongStream.rangeClosed(0, n).reduce(0, Long::sum);
    }

    public static long parallelPrimitiveSTreamsSum(long n) {
        return LongStream.rangeClosed(0, n).parallel().reduce(0, Long::sum);
    }

    public static long sequentialNonPrimitiveStreamsSum(long n) {
        return LongStream.iterate(0L,  i-> i+1).limit(n).reduce(0L, Long::sum);
    }

    public static long parallelNonPrimitiveSTreamsSum(long n) {
        return LongStream.iterate(0L,  i-> i+1).limit(n).parallel().reduce(0L, Long::sum);
    }
}
