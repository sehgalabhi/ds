package com.java8inaction;

import java.util.stream.LongStream;

public class ParallelStreamsTest {
    public static void main(String[] args) {
        new ParallelStreamsTest().test();
    }

    private void test() {
        
        testIncorrectStreams();
    }

    private void testIncorrectStreams() {
        System.out.println("Ranged sum done in " + MeasuringSumPerformance.measure(this::sideEffectSum, 1_000_000)+ "msecs");
        System.out.println("Ranged parallelsum done in " + MeasuringSumPerformance.measure(this::sideEffectParallelSum, 1_000_000)+ "msecs");

    }

    private long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).forEach(accumulator::add);
        return accumulator.total;
    }

    private long sideEffectParallelSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    class Accumulator{
        long total =0;
        public void add(long value){
            total+=value;
        }
    }
}
