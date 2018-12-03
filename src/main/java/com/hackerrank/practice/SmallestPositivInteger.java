package com.hackerrank.practice;

import java.util.Arrays;

public class SmallestPositivInteger {

    public static void main(String[] args) {
        SmallestPositivInteger smallestPositivInteger = new SmallestPositivInteger();
        System.out.println(smallestPositivInteger.test(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(smallestPositivInteger.test(new int[]{1, 2,3}));
        System.out.println(smallestPositivInteger.test(new int[]{-1, -3}));

    }

    private int test(int[] A) {
        Arrays.sort(A);

        int smallestPositive = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] <= 0 ){
                continue;
            }
            if(A[i] ==smallestPositive){
                smallestPositive++;
            } else if(A[i]> smallestPositive){
                return smallestPositive;
            }
        }
        return smallestPositive;
    }
}
