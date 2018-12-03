package com.exceptions;

public class NoClassDefFoundErrorExample {

    public static void main(String[] args) {
        new NoClassDefFoundErrorExample().test();
    }

    private void test() {
        ClassWithInitErrors classWithInitErrors;
        try {
            classWithInitErrors = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
        }
    }

}

