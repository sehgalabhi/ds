package com.java8inaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectorsVsReduce {

    public static void main(String[] args) {
        new CollectorsVsReduce().test();
    }

    private void test() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer e) -> {
            l.add(e);
            return l;
        }, (List<Integer> l, List<Integer> l1) -> {
            l.addAll(l1);
            return l;
        });

    }
}
