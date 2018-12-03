package com.hackerrank.practice;

import java.util.Arrays;

public class PairsWithDifference {

    public static void main(String[] args) {
        PairsWithDifference pairsWithDifference = new PairsWithDifference();
//        pairsWithDifference.test(new int[]{1, 5, 3, 4, 2}, 2);
//        pairsWithDifference.test(new int[]{1,  5, 3, 4, 2}, 2);
//        pairsWithDifference.test(new int[]{1,  5, 3, 4, 2}, 1);
        pairsWithDifference.test(new int[]{1 ,3 ,5, 8, 6 ,4 ,2}, 2);

    }

    private void test(int[] arr, int k) {
        int count = 0;
        Arrays.sort(arr);

        int[] diff = new int[arr.length-1];

        for (int i = 0; i < arr.length - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        System.out.println(Arrays.toString(diff));
        for (int i = 0; i < diff.length; i++) {
            int temp = i;
            int sum = diff[i];
            while (sum <= k && temp < diff.length) {
                if(sum == k) {
                    count++;
                    sum = diff[temp];
                    break;
                }
                temp++;
                if(temp < diff.length){
                    sum += diff[temp];

                }
            }
        }

        System.out.println(count);
    }
}
