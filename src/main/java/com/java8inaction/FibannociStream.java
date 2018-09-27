package com.java8inaction;

import java.util.stream.Stream;

public class FibannociStream {

    public static void main(String[] args) {
        new FibannociStream().test();
    }

    private void test() {

        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.limit(5).forEach(System.out::println);


        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }
}
