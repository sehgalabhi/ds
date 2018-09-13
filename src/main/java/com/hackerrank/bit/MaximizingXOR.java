package com.hackerrank.bit;

public class MaximizingXOR {
    public static void main(String[] args) {
        new MaximizingXOR().test(11,100);
    }

    private void test(int l, int r) {

        int max =0;
        int startIndex = l;
        int endIndex = r;
        while (startIndex <= endIndex) {
            for (int j = l; j <= endIndex; j++) {
                int xor = startIndex ^ j;
                if(startIndex==l) {
                    max = startIndex ^ j;
                }
                if(xor > max) {
                    max = xor;
                }
            }
            startIndex++;
        }

        System.out.println(max);

    }
}
