package com.hackerrank.dynamicprog;

public class MaxArraySum {
    public static void main(String[] args) {
        new MaxArraySum().test(new int[]{-2, 1, 3, -4, 5});
        new MaxArraySum().test(new int[]{3, 7, 6, 4, 5});
        new MaxArraySum().test(new int[]{3, 7, 4, 6, 5});
        new MaxArraySum().test(new int[]{3, 5, -7, 8, 10});
        new MaxArraySum().test(new int[]{2, 1, 5, 8, 4});

    }

    private void test(int[] ints) {
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < ints.length - 2; i++) {
            int temp = Integer.MIN_VALUE;

            temp = maxSum(i, ints.length, ints, 2, sum);


            if (sum < temp) {
                sum = temp;
            }
        }

        System.out.println(sum);


    }

    private int maxSum(int start, int end, int[] ints, int gap, int tempSum) {
        int sum = Integer.MIN_VALUE;

        int temp = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int k = start; k < end; k += gap) {
            stringBuffer.append(ints[k]).append(":");
            temp += ints[k];
//                sum+= ints[j];
            if (k != start) {
                if (temp > sum) {
                    sum = temp;
                }
            }

        }

        if (tempSum < sum) {
            tempSum = sum;
        }

        gap++;
        if (end - start >= gap) {
            tempSum = maxSum(start, end, ints, gap, tempSum);
        }


        return tempSum;


    }
}
