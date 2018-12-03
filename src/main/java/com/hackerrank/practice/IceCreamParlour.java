package com.hackerrank.practice;

import java.util.Arrays;
import java.util.List;

public class IceCreamParlour {

    public static void main(String[] args) {
        IceCreamParlour iceCreamParlour = new IceCreamParlour();

        /*int[] arr = new int[]{1,4,5,3,2};
        iceCreamParlour.test(arr);

        arr = new int[]{2,2,4,3};
        iceCreamParlour.test(arr);*/

//        int[] arr = new int[]{1 ,2 ,3 ,5 ,6};
        int[] arr = new int[]{1, 4, 5, 3, 2};
//        int[] arr = new int[]{1,2,3,4,5,6,7,8};
//        iceCreamParlour.test(arr, 4);
//        iceCreamParlour.test(new int[]{1,4,5, 3,2}, 4);
        iceCreamParlour.test(new int[]{7, 2, 5, 4, 11}, 12);
    }

    private void test(int[] cost, int money) {

        int[] origs = Arrays.copyOf(cost, cost.length);
        Arrays.sort(cost);
//        System.out.println(Arrays.toString(cost));

        /*int midIndex =arr.length/2;
        int lo =0, hi = arr.length;
        while (true) {
            if(arr[midIndex] >= amount) {
                hi = midIndex;
                midIndex = midIndex/2;
            } else {
                break;
            }

        }*/

        int midIndex = cost.length / 2;
        int lowVal, hiVal = 0;
        int curr = 0, another = midIndex;
        boolean isAnotherReduced = false;
        while (true) {
            if (cost[curr] + cost[another] == money) {
                lowVal = cost[curr];
                hiVal = cost[another];
                break;
            } else if (cost[curr] + cost[another] > money) {
                if (another - curr > 1) {
                    another = another - 1;
                    isAnotherReduced = true;
                }
            } else {
                if (isAnotherReduced) {
                    curr = curr + 1;
                    isAnotherReduced = false;
                } else {

                    another = another + 1;
                }
            }

        }

        int first = 0, second = 0;
        for (int i = 0; i < origs.length; i++) {
            if (origs[i] == lowVal || origs[i] == hiVal) {
                if (first != 0) {
                    second = i + 1;
                    break;
                }
                first = i + 1;


            }
        }
        System.out.println(first + " " + second);

    }
}
