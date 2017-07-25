package com.codinginter.one;

/**
 * Created by asehgal on 7/25/2017.
 */
public class Four_PalindromePermutation {

    public static void main(String[] args) {
        new Four_PalindromePermutation().test();
    }

    private void test() {
        String input = "tact coa";
        if (!isPalindromePermutation(input)) {
            throw new IllegalStateException();
        }

        input = "act coa";
        if (isPalindromePermutation(input)) {
            throw new IllegalStateException();
        }

    }

    private boolean isPalindromePermutation(String input) {
        char[] alphabets = new char[27];
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            if (input.charAt(i) == ' ') {
                alphabets[26] += 1;
            } else {
                alphabets[index] += 1;
            }
        }

        int maxUnique = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] == 1 && alphabets[i] != ' ') {
                maxUnique += 1;
            }
        }
        if (maxUnique > 1) return false;
        return true;
    }
}
