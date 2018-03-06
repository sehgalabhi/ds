package com.java8inaction;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericRangesTest {

    public static void main(String[] args) {
        new NumericRangesTest().test();
    }

    private void test() {
        testRange();
        testPythagoreanTriples();
    }

    private void testRange() {
        IntStream.range(1, 10).forEach(System.out::print);
        IntStream.rangeClosed(1, 10).forEach(System.out::print);
    }

    private void testPythagoreanTriples() {
        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
                IntStream.rangeClosed(a, 100).boxed().filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).map(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}));
        System.out.println(stream.map(index -> "(" + index[0] + "," + index[1] + "," + index[2] + ")").limit(4).collect(Collectors.toList()));

    }
}
