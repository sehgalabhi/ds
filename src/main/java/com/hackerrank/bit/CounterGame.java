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


        if (isPowerOf2(i)) {
            return i / 2;
        }

        long n = findHigestNumber(i);


        return i - n;
    }

    private static long findHigestNumber(long i) {
        long val = 2;

        while (true) {
            if(Long.MAX_VALUE - val < val){
                return val;
            }
            if((val << 1) > i){
                return val;
            }
            val = val << 1;

        }
    }

    private static boolean isPowerOf2(long i) {
        long val = 2;
        while (true) {
            if (val == i) {
                return true;
            } else if (val > i) {
                return false;
            }
            if(Long.MAX_VALUE - val < val){
                return false;
            }

            val = val << 1;
        }
    }

}
