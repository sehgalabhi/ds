package com.codinginter.one;

/**
 * Created by asehgal on 7/25/2017.
 */
public class Three_URLify {

    public static void main(String[] args) {
        new Three_URLify().test();
        
    }

    private void test() {
        String s1 = "Mr John Smith ";

        if(!urlify(s1).equals("Mr%20John%20Smith")){
            throw  new IllegalStateException();
        }
    }

    private String urlify(String s1) {
        return s1.trim().replace(" ", "%20");
    }
}
