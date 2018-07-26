package com.memory;

import com.java8inaction.Dish;

import java.util.ArrayList;
import java.util.List;

public class TestRuntime {

    private static final long MEGABYTE = 1024L * 1024L;

    public static void main(String[] args) {
        new TestRuntime().test();
    }

    private void test() {
        Runtime runtime = Runtime.getRuntime();
        List<Dish> dishes = new ArrayList<>();
        long usedMemory1 = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(usedMemory1/MEGABYTE);

        System.out.println(runtime.totalMemory()/MEGABYTE);
        System.out.println(runtime.freeMemory()/MEGABYTE);
        for (int i = 0; i < 1_00_000; i++) {
            dishes.add(new Dish("pizza", true, 550, Dish.Type.OTHER));
        }


        long usedMemory2 = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(usedMemory2/MEGABYTE);

        runtime.gc();

        long usedMemory3 = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(usedMemory3/MEGABYTE);


        System.out.println(runtime.totalMemory()/MEGABYTE);
        System.out.println(runtime.freeMemory()/MEGABYTE);

    }
}
