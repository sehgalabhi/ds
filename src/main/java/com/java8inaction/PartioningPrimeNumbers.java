package com.java8inaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartioningPrimeNumbers {
    public static void main(String[] args) {
        new PartioningPrimeNumbers().test();


    }

    private void test() {

        boolean prime = isPrime(6);

        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, 100).boxed().collect(Collectors.partitioningBy(t -> isPrime(t)));

        System.out.println(collect);
    }

    private boolean isPrime(int n) {
        int squareRoot = (int) Math.sqrt(n);
        return IntStream.rangeClosed(2, squareRoot).noneMatch(t -> n % t == 00);
    }
}
