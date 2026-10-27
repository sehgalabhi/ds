package com.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int process = -1;

        process=         test1.process(Arrays.asList(9,10,2,5));
        System.out.println(process);

        process=         test1.process(Arrays.asList(9,10,5,2));
        System.out.println(process);


        process=         test1.process(Arrays.asList(-9,10,2,5));
        System.out.println(process);


        process=         test1.process(Arrays.asList(10,10));
        System.out.println(process);

        process=         test1.process(Arrays.asList(2, 3, 10, 2, 4, 8, 1));
        System.out.println(process);

        process=         test1.process(Arrays.asList(1,2,6,4));
        System.out.println(process);




    }

    private int process(List<Integer> arr) {

        int maxDiff = -1;

        for (int i = 1; i < arr.size(); i++) {

            int comparisonIndex = i - 1;
            while (comparisonIndex >= 0) {
                if (arr.get(i) > arr.get(comparisonIndex)) {
                    int currDiff = arr.get(i) - arr.get(comparisonIndex);
                    if (currDiff > maxDiff) {
                        maxDiff = currDiff;
                    }
                } else {
                    break;
                }
                comparisonIndex--;
            }

        }
        return maxDiff;

    }

    /*private int process(int[] arr) {

        for (int i = 0; i < i; i++) {

        }
        Arrays.sort(arr);

        int maxDiff = arr[arr.length-1] - arr[0];
        if(maxDiff == 0) {
            maxDiff = -1;
        }
        return maxDiff;

    }*/
}
