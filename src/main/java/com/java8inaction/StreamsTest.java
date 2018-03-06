package com.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {
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
        new StreamsTest().test();
    }

    private void test() {
        testLowCaloricDishesName();
        testDIshesByType();
        testUniqueElementsInStream();
        testTruncateElements();
        testSkipElements();
        testNumbersOfCharacters();
        testUniqueCharacters();
        testSquareOfEachNumber();
        testPairsFromTwoLists();
        testPredicates();
        testNumericCaloriesCount();

    }

    private void testLowCaloricDishesName() {
        System.out.println(menu.stream().filter(dish -> dish.getCalories() < 400).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList()));
    }

    private void testDIshesByType() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect);
    }

    private void testUniqueElementsInStream() {
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        System.out.println(numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList()));
    }

    private void testTruncateElements() {
        System.out.println(menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList()));
    }

    private void testSkipElements() {
        System.out.println(menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList()));
    }

    private void testNumbersOfCharacters() {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        System.out.println(words.stream().map(String::length).collect(Collectors.toList()));
    }

    private void testUniqueCharacters() {
        List<String> words = Arrays.asList("Hello", "World");
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> stream1 = Arrays.stream(arrayOfWords);
        System.out.println(stream1.collect(Collectors.toList()));
        Stream<Stream<String>> streamStream = words.stream().map(s -> s.split("")).map(Arrays::stream);
        words.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);
        System.out.println();
    }

    private void testSquareOfEachNumber() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().map(i -> i * i).collect(Collectors.toList()));
    }

    private void testPairsFromTwoLists() {
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);

        Stream<int[]> stream = numbers1.stream().flatMap(integer1 ->
                numbers2.stream().map(integer2 -> new int[]{integer1, integer2})
        );
        List<int[]> collect = stream.collect(Collectors.toList());
        collect.stream().map(index -> "(" + index[0] + "," + index[1] + ") ").forEach(System.out::print);
        System.out.println();
        collect.stream().filter(index -> (index[0] + index[1]) %3 ==0).map(index -> "(" + index[0] + "," + index[1] + ") ").forEach(System.out::print);
        System.out.println();
    }

    private void testPredicates() {
        System.out.println(menu.stream().anyMatch(Dish::isVegetarian));
        System.out.println(menu.stream().allMatch(dish -> dish.getCalories()<1000));
        System.out.println(menu.stream().noneMatch(dish -> dish.getCalories() > 1000));
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));
    }

    private void testNumericCaloriesCount() {
        System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        menu.stream().mapToInt(Dish::getCalories).max().orElse(1);
    }
}