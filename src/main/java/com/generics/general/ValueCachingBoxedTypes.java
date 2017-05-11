package com.generics.general;

import java.util.Arrays;
import java.util.List;

/**
 * Created by asehgal on 5/11/2017.
 */
public class ValueCachingBoxedTypes {
    public static void main(String[] args) {
        ValueCachingBoxedTypes valueCachingBoxedTypes = new ValueCachingBoxedTypes();
        valueCachingBoxedTypes.test();
        valueCachingBoxedTypes.test1();


    }

    private void test() {
        List<Integer> bigs = Arrays.asList(100, 200, 300);
        assert sumInteger(bigs) == sum(bigs);
        //reference should be equal and they are not
        assert sumInteger(bigs) != sumInteger(bigs);

    }


    private void test1() {
        List<Integer> bigs = Arrays.asList(1, 2, 3);
        assert sumInteger(bigs) == sum(bigs);
        //reference are equal becuase of caching
        assert sumInteger(bigs) == sumInteger(bigs);

    }

    private int sum(List<Integer> bigs) {
        int s = 0;
        for (int n : bigs
                ) {
            s += n;
        }
        return s;
    }

    private Integer sumInteger(List<Integer> bigs) {
        Integer s = 0;
        for (Integer n : bigs
                ) {
            s += n;
        }
        return s;
    }


}
