package com.java8inaction;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriple {

    public static void main(String[] args) {
        new PythagoreanTriple().test();
    }

    private void test() {
        IntStream intStream = IntStream.rangeClosed(1, 100);

        Stream<Integer> boxed = intStream.boxed();

        Stream<int[]> stream = boxed.flatMap(i -> IntStream.rangeClosed(i + 1, 100).boxed().filter(j -> Math.sqrt(i * i + j * j) % 1 == 0).map(j -> new int[]{i, j, (int)Math.sqrt(i * i + j * j)}));
        stream.limit(5).forEach(t-> System.out.println(Arrays.toString(t)));
//        stream.forEach(t-> System.out.println(Arrays.toString(t)));


    }
}
