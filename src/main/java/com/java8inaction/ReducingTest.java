package com.java8inaction;

import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReducingTest {
    static List<Integer> numbers = Arrays.asList(1,2,3,4,5);
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
        new ReducingTest().test();
    }

    private void test() {
        testSum();
        testMaximum();
        testNumberOfDishes();
    }

    private void testSum() {
        System.out.println(numbers.stream().reduce(0, (integer, integer2) -> integer + integer2));
        Optional<Integer> reduce = numbers.stream().reduce((integer, integer2) -> integer + integer2);
    }

    private void testMaximum() {
        System.out.println(numbers.stream().reduce(0, Integer::max));
    }

    private void testNumberOfDishes() {
        System.out.println(menu.stream().map(dish -> 1).reduce(0, (val, val2) -> val + val2));
    }
}
