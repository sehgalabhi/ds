package com.generics.general;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by asehgal on 5/11/2017.
 */
public class Utilities {

    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }

    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);

    }

    public static <T extends Object & Comparable<T>> T max(Collection<? extends T> coll) {
        T candiate = coll.iterator().next();
        for (T elt : coll) {
            if (candiate.compareTo(elt) < 0) {
                candiate = elt;
            }
        }
        return candiate;
    }

    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (cmp.compare(candidate, elt) < 0) {
                candidate = elt;
            }
        }
        return candidate;
    }

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder(){
        return new Comparator<T>() {
            @Override
            public int compare(T t, T t1) {
                return t.compareTo(t1);
            }
        };
    }
}
