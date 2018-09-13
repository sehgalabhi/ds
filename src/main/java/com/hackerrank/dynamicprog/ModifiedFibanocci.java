package com.hackerrank.dynamicprog;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ModifiedFibanocci {

    public static void main(String[] args) {
        System.out.println(new ModifiedFibanocci().fibMod(0, 1, 5));

    }

    private static Map<Integer, BigInteger> cache = new HashMap<>();


    private static BigInteger fibMod(int t1, int t2, int n) {
        if (n == 1) {
            return BigInteger.valueOf(t1);
        }
        if (n == 2) {
            return BigInteger.valueOf(t2);
        }
        if (!cache.containsKey(n)) {
            BigInteger add = fibMod(t1, t2, n - 2).add((fibMod(t1, t2, n - 1).multiply(fibMod(t1, t2, n - 1))));
            cache.put(n, add);
        }
        return cache.get(n);

    }


}
