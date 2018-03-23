package com.java8inaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorsTest {

    private final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        new CollectorsTest().test();
    }

    private void test() {
        //reducing
        testCount();
        testMaxCalory();

        //summarizing
        testTotalCalories();
        testSummarizingInt();
        testJoining();
        testReducing();
        testIncorrectReducing();
        testCorrectReducing();
    }

    private void testCorrectReducing() {
        menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
    }

    private void testIncorrectReducing() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> reduce = numbers.stream().reduce(new ArrayList<Integer>(), (List<Integer> l, Integer toAdd) -> {
            l.add(toAdd);return l;
        }, (List<Integer> a, List<Integer> b) -> {
            a.addAll(b);
            return a;
        });
        System.out.println(reduce);
    }

    private void testReducing() {
        menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (a,b) -> a+b));
    }

    private void testJoining() {
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(",")));
    }

    private void testSummarizingInt() {
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(collect);
    }

    private void testTotalCalories() {
        System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());
        System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalories)));
        System.out.println(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)));
    }

    private void testCount() {
        System.out.println(menu.stream().count());
        Long collect = menu.stream().collect(counting());
        System.out.println(collect);
    }

    private void testMaxCalory() {
        Optional<Dish> collect = menu.stream().collect(maxBy(Comparator.comparing(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }
}
