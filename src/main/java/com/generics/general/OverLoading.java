package com.generics.general;

/**
 * Created by asehgal on 9/15/2017.
 */
public class OverLoading {

    public static void main(String[] args) {
        new OverLoading().test();
    }

    private void test() {

        merge("test");
        merge(Integer.valueOf(1));

    }


    private <T extends String>  T merge(T val) {
        System.out.println("in specifc");
        return val;
    }

    private <T> T merge(T val) {
        System.out.println("in generics");
        return val;
    }

    /*public <T extends Number> T sayHi() {
        System.out.println("number");
        return null;
    }

    public <T extends Integer> T sayHi() {
        System.out.println("integer");
        return null;
    }*/


    }
