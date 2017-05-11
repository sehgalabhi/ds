package com.generics.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by asehgal on 5/11/2017.
 */
public class FruitWithoutCrossComparison {
    public static void main(String[] args) {
        new FruitWithoutCrossComparison().test();
    }

    private void test() {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Orange o3 = new Orange(3);
        Orange o4 = new Orange(4);
        List<Apple> apples = Arrays.asList(a1, a2);
        assert Collections.max(apples).equals(a2);
        List<Orange> oranges = Arrays.asList(o3, o4);
        assert Collections.max(oranges).equals(o4);
        List<Fruit> mixed = Arrays.<Fruit>asList(a1, o3);
      //  assert Collections.max(mixed).equals(o3); // compile-time error
    }
}



class Fruit {
    private int size;
    private String name;

    public Fruit(int size, String name) {
        this.size = size;
        this.name = name;
    }

    protected int compare(Fruit that) {
        return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
    }
}

class Apple extends Fruit implements Comparable<Apple> {
    public Apple(int size) {
        super(size, "Apple");
    }

    @Override
    public int compareTo(Apple apple) {
        return compare(apple);
    }
}

class Orange extends Fruit implements Comparable<Orange> {
    public Orange(int size) {
        super(size, "Orange");
    }

    @Override
    public int compareTo(Orange orange) {
        return compare(orange);
    }
}
