package com.hackerrank.inner;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class InnerHRTest {

    private String test = "hello";

    public static void main(String[] args) {
        Static inner = new Static();
        Object o;
        o = inner.new Private();
        System.out.println(((Static.Private) o).powerof2(8));

        new InnerHRTest().test();

    }


    private void test(int... n1) {
        for (int i = 0; i < n1.length; i++) {
            if (BigInteger.valueOf(n1[i]).isProbablePrime(1)) {
//                System.out.print(n1[i] + "\" );
            }
        }

        System.out.println();

        IntStream.of(n1).filter(t -> BigInteger.valueOf(t).isProbablePrime(1)).forEach(System.out::print);
        Inner inner = new Inner();
        Inner.Private aPrivate = inner.new Private();
        System.out.println(aPrivate.powerof2(8));
    }

    static class Static {
        private class Private {
            private String powerof2(int num) {

                return ((num & (num - 1)) == 0) ? "power of 2" : "not a power of 2";
            }
        }

        private void test() {
            System.out.println("hey");
        }
    }

    private class Inner {
        private class Private {
            private String powerof2(int num) {
                System.out.println(test);
                return ((num & (num - 1)) == 0) ? "power of 2" : "not a power of 2";
            }
        }

        private void test() {
            System.out.println("hey");
        }
    }
}
