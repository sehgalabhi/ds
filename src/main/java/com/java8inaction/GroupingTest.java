package com.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingTest {
    enum CaloricLevel {DIET, NORMAL, FAT}

    ;
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
        new GroupingTest().test();
    }

    private void test() {
        testClassifyDishes();
        testTypeCaloricGrouping();
        testTypeCountGrouping();
        testPartitionVegNonveg();
    }

    private void testPartitionVegNonveg() {
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(collect);
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect1 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(collect1);
    }

    private void testTypeCountGrouping() {
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect);
        Map<Dish.Type, Optional<Dish>> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(collect1);

        Map<Dish.Type, Dish> collect2 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect2);
    }

    private void testTypeCaloricGrouping() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(d -> {
                    if (d.getCalories() < 400)
                        return CaloricLevel.DIET;
                    else if (d.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }))
        );
        System.out.println(collect);
    }

    private void testClassifyDishes() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect);
        Map<CaloricLevel, List<Dish>> collect1 = menu.stream().collect(Collectors.groupingBy(d -> {
            if (d.getCalories() < 400)
                return CaloricLevel.DIET;
            else if (d.getCalories() < 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        }));
        System.out.println(collect1);

        Map<CaloricLevel, Set<Dish>> collect2 = menu.stream().collect(Collectors.groupingBy(d -> {
            if (d.getCalories() < 400)
                return CaloricLevel.DIET;
            else if (d.getCalories() < 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        }, Collectors.toCollection(HashSet::new)));
    }
}
