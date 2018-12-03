package com.hackerrank.practice;

import java.util.Arrays;

public class ToysShipmentGreedy {

    public static void main(String[] args) {
        ToysShipmentGreedy toysShipmentGreedy = new ToysShipmentGreedy();
        System.out.println(toysShipmentGreedy.test(new int[]{1, 2, 3, 21, 7, 12, 14, 21}));
        System.out.println(toysShipmentGreedy.test(new int[]{1, 2, 3, 4, 5, 10, 11, 12, 13}));
    }

    private int test(int[] w) {
        if (w.length == 0) {
            return 0;
        }
        Arrays.sort(w);


        int count = 1;
        int lowest = w[0];
        for (int i = 0; i < w.length; i++) {
            if (w[i] - lowest > 4) {
                lowest = w[i];
                count++;
            }

        }
        return count;
    }
}
