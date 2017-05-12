package com.generics.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by asehgal on 5/11/2017.
 */

public class FruitWithCrossComparison {


    public static void main(String[] args) {
        new FruitWithCrossComparison().test();
    }

    void test() {
        Apple a1 = new Apple(1); Apple a2 = new Apple(2);
        Orange o3 = new Orange(3); Orange o4 = new Orange(4);
        List<Apple> apples = Arrays.asList(a1,a2);
        assert Collections.max(apples).equals(a2);
        List<Orange> oranges = Arrays.asList(o3,o4);
        assert Collections.max(oranges).equals(o4);

        List<Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
        assert Collections.max(mixed).equals(o3); // ok
    }

    class Fruit implements Comparable<Fruit> {

        private String name;
        private int size;

        protected Fruit(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public int compareTo(Fruit that) {
            return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
        }

    }

    class Apple extends Fruit {
        public Apple(int size) {
            super("Apple", size);
        }
    }

    class Orange extends Fruit {
        public Orange(int size) {
            super("Orange", size);
        }
    }
}

