package com.hackerrank.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayRotation {
    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation();
        int[] ints = {1, 2, 3, 4, 5};
        arrayRotation.test(new int[]{41,73,89,7,10,1,59,58,84,77,77,97,58,1,86,58,26,10,86,51}, 10);
        arrayRotation.test(ints, 1);
        arrayRotation.test(ints, 2);
        arrayRotation.test(ints, 3);
        arrayRotation.test(ints, 4);
        arrayRotation.test(ints, 5);
        arrayRotation.test(ints, 6);
        arrayRotation.test(ints, 7);
    }

    private void test(int[] a, int d) {
        int length = a.length;
        int temp[] = new int[length];

        int toRotate = d % length;
        for (int j = 0; j < length; j++) {
            int diff = j-toRotate < 0? length-(Math.abs(j-toRotate)): j-toRotate;
            temp[diff] = a[j];
        }
        System.out.println(Arrays.stream(temp).boxed().map(t -> String.valueOf(t)).collect(Collectors.joining(" ")));
    }
}
