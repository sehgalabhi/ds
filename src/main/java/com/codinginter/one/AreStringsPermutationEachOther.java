package com.codinginter.one;

/**
 * Created by asehgal on 7/25/2017.
 */
public class AreStringsPermutationEachOther {

    public static void main(String[] args) {
        new AreStringsPermutationEachOther().test();
    }

    private void test() {
        String a1 = "abac";
        String b1 = "aabc";

        if (!isPermutation(a1, b1)) {
            throw new IllegalStateException();
        }

        a1 = "abaac";
        b1 = "aabc";

        if (isPermutation(a1, b1)) {
            throw new IllegalStateException();
        }

    }

    private boolean isPermutation(String a1, String b1) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a1.length(); i++) {
            sum1 += a1.charAt(i);
        }

        for (int i = 0; i < b1.length(); i++) {
            sum2 += b1.charAt(i);
        }

        if (sum1 == sum2) {
            return true;
        } else {
            return false;
        }


    }
}
