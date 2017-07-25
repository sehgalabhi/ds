package com.codinginter.one;

/**
 * Created by asehgal on 7/25/2017.
 */
public class One_IsUniqueStringCharacters {

    public static void main(String[] args) {
        new One_IsUniqueStringCharacters().test();
    }

    private void test() {
        String abc = "abc";
        if (isUnique(abc) != true) {
            throw new IllegalStateException();
        }

        String abac = "abac";
        if (isUnique(abac) != false) {
            throw new IllegalStateException();
        }

    }

    private boolean isUnique(String input) {
        char[] alphabets = new char[26];
        for (int i = 0; i < input.length(); i++) {
            int index = (int) input.charAt(i) - 'a';
            if (alphabets[index] == 1) {
                return false;
            }
            alphabets[index] = 1;
        }
        return true;
    }
}
