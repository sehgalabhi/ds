package com.hackerrank.bit;

public class XORSequence {

    public static void main(String[] args) {
int i =0;
int res =0;
        while (i <= 16) {
            if (i == 0) {
                res = 0;
            } else {

                res = res ^ i;
            }
            System.out.println(res);
            i++;
        }


        System.out.println(new XORSequence().test(5, 9));

        int newL = 5 % 8;
        int newR = 9 % 8;

        System.out.println(new XORSequence().test(newL, newR));
    }

    private long test(long l, long r) {
        long pad = 0L;


        long i = 0;

        long res = pad;
        while (i <= l) {
            if (i == 0) {
                res = 0;
            } else {

                res = res ^ i;
            }
            i++;
        }

        long valueToUse = res;
        while (i <= r) {
            valueToUse = valueToUse ^ i;
            res = res ^ valueToUse;
            i++;
        }
        return res ^ pad;

    }
}
