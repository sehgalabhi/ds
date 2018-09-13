package com.codinginter.one;

import java.util.Arrays;

public class CoinChange {

    private long count =0l;


    public static void main(String[] args) {
//        new CoinChange().getWays(4 , new long[]{1,2,3});
//        new CoinChange().recurs(4 , 0,new long[]{1,2,3}, 0);

        String s1 = "anagram", s2 ="margana";

        if(s1.toLowerCase().chars().sum() == s2.chars().sum()){

        }
    }

    private void getWays(long toMatch, long[] c) {

        int i =0;
        while (i < c.length){



        }
    }

    private boolean recurs(long toMatch, int index, long[] elems, long accumulate){

        if(accumulate == toMatch){
            count++;
            return true;
        } else if(accumulate < toMatch) {
            boolean toContinue= recurs(toMatch, index, elems, accumulate+elems[index]);


            if(!toContinue) {

            }
            return true;
        } else {
            recurs(toMatch, index, elems, accumulate + elems[index]);
            return false;
        }

    }

    private long sum (long... elems){
        long sum = Arrays.stream(elems).sum();
        return sum;
    }

    private void loop(long n, long[] elems) {
        long sum = Arrays.stream(elems).sum();
        if(sum == n) {
            return;
        }
    }
}
