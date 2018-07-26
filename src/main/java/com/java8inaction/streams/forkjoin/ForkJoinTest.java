package com.java8inaction.streams.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

    public static long test(long n) {

        LongStream longStream = LongStream.rangeClosed(1, n);
        long[] longs = longStream.toArray();

        ForkJoinSumCalculator forkJoinSumCalculatorTask = new ForkJoinSumCalculator(longs);
        Long invoke = new ForkJoinPool().invoke(forkJoinSumCalculatorTask);
        return invoke;

    }
}

class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private long[] numbers;


    public static final long THRESHHOLD = 1000;
    private int start;
    private int end;

    public ForkJoinSumCalculator(long[] numbers) {
        this.numbers = numbers;
        this.end = numbers.length;
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start > THRESHHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, (end - start) / 2);
            ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, (end - start) / 2 + 1, end);
            leftTask.fork();
            Long rightResult = rightTask.compute();
            Long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}
