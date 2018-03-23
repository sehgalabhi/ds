package com.java8inaction;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) {
        new ForkJoinTest().test();
    }

    private void test() {
        long[] longs = LongStream.rangeClosed(1, 10_000_000).toArray();
        ForkJoinTask forkJoinSumCalculator = new ForkJoinSumCalculator(longs);
        System.out.println(new ForkJoinPool().invoke(forkJoinSumCalculator));

    }
}

class ForkJoinSumCalculator extends RecursiveTask<Long> {

    long[] numbers;
    int start;
    int end;
    long THRESHHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, (start+length)/2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, (start+length)/2,  end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
