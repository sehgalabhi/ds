package com.java8inaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {

    public static void main(String[] args) {
        new FlatMapTest().test(Arrays.asList("Hello", "World"));

        new FlatMapTest().testSquareOfNumbers(Arrays.asList(1, 2, 3, 4, 5));

        new FlatMapTest().testPairOfNumbers();
        new FlatMapTest().testPairOfNumbersSumDivisibleBy3();

    }

    private void testPairOfNumbersSumDivisibleBy3() {

        List<Integer> one = Arrays.asList(1, 2, 3);
        List<Integer> two = Arrays.asList(3, 4);

        Stream<int[]> streamStream = one.stream().flatMap(i -> {
            return two.stream().filter(j -> i + j % 3 == 0).map(j -> {
                return new int[]{i, j};

            });
        });

        List<int[]> collect = streamStream.collect(Collectors.toList());
        collect.stream().forEach(t -> System.out.println(Arrays.toString(t)));

    }

    private void testPairOfNumbers() {
        List<Integer> one = Arrays.asList(1, 2, 3);
        List<Integer> two = Arrays.asList(3, 4);

        Stream<int[]> streamStream = one.stream().flatMap(i -> {
            return two.stream().map(j -> {
                return new int[]{i, j};
            });
        });

        List<int[]> collect = streamStream.collect(Collectors.toList());
        collect.stream().forEach(t -> System.out.println(Arrays.toString(t)));
    }

    private void testSquareOfNumbers(List<Integer> ts) {
        System.out.println(ts.stream().map(t -> t * t).collect(Collectors.toList()));
    }


    private void test(List<String> input) {

        input.stream().map(t -> t.split("")).distinct().forEach(System.out::println);
        Stream<String[]> stream = input.stream().map(t -> t.split(""));
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        stringStream.distinct().forEach(System.out::println);
    }
}
