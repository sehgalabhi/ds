package com.codinginter.one;

/**
 * Created by asehgal on 7/25/2017.
 */
public class Five_OneAway {

    public static void main(String[] args) {
        new Five_OneAway().test();
    }

    private void test() {
        String a1 = "pale";
        String b1 = "ple";

        if(!isOneAway(a1, b1)){
            throw new IllegalStateException();
        }

        a1 = "pales"; b1 = "pale";
        if(!isOneAway(a1, b1)){
            throw new IllegalStateException();
        }

        a1 = "pale"; b1 = "bale";
        if(!isOneAway(a1, b1)){
            throw new IllegalStateException();
        }

        a1 = "pale"; b1 = "bake";
        if(isOneAway(a1, b1)){
            throw new IllegalStateException();
        }
    }

    private boolean isOneAway(String a1, String b1) {
        char[] alphabets = new char[26];
        for (int i = 0; i < a1.length(); i++) {
            int index = a1.charAt(i) - 'a';
            alphabets[index] += 1;
        }

        for (int i = 0; i < b1.length(); i++) {
            int index = b1.charAt(i) - 'a';
            alphabets[index] += 1;
        }

        int maxUnique = 0;
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == 1 ) {
                maxUnique += 1;
            }
        }
        if (maxUnique > 2) return false;
        return true;
    }
}
