package com.hackerrank.bit;

public class CounterGame {

    public static void main(String[] args) {

        System.out.println(new CounterGame().test(Long.MAX_VALUE));
    }

    int num = 2;

    private String test(long n) {
        boolean isLouise = true;

        if(n ==1 ) {
            return "Richard";
        }
        long nextNumber = n;
        while (true) {
            nextNumber = highestPowerOf2(nextNumber);
            if (nextNumber == 1) {
                break;
            }
            if (isLouise) {
                isLouise = false;
            } else {
                isLouise = true;
            }
        }


        if (isLouise) {
            return "Louise";
        } else {
            return "Richard";
        }

    }

    private static long highestPowerOf2(long i) {
        int start = 0;
        long val = 2;

        if (isPowerOf2(i)) {
            return i / 2;
        }

        while (val <= i && (Long.MAX_VALUE - val >=val) && (val << start + 1) <= i) {
            start++;
            val <<= start;
        }
        return i - val;
    }

    private static boolean isPowerOf2(long i) {
        int start = 0;
        long val = 2;
        long res = 0;
        while (true) {
            if(Long.MAX_VALUE - res >res) {
                return false;
            }
            res = val << start;
            if (res == i) {
                return true;
            } else if (res > i) {
                return false;
            }
            start++;
        }

    }

}
