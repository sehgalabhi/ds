package com.hackerrank.bit;

public class LonelyInteger {

    private static int CONST = -1;
    public static void main(String[] args) {
        int[] values = new int[]{1, 1, 2};

        System.out.println(new LonelyInteger().test(values));
    }

    private int test( int[] values) {

        int result = CONST;

        if(values.length ==1 ){
            return values[0];
        }

        for (int i = 0; i < values.length ; i++) {
            result ^= values[i] ;
        }

        return result ^ CONST;


    }
}
