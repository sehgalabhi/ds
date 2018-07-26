package com.datatype;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        new BigDecimalTest().test();
    }

    private void test() {
        BigDecimal bigDecimal = new BigDecimal("1");
        BigDecimal bigDecimal_00 = new BigDecimal("1.00");
        BigDecimal bigDecimal1 = new BigDecimal("0.00");
        BigDecimal bigDecimal2 = new BigDecimal("12.3");
        BigDecimal bigDecimal3 = new BigDecimal("0.00123");
        BigDecimal bigDecimal4 = new BigDecimal("12.0");

        System.out.println(bigDecimal.compareTo(bigDecimal_00) ==0);



        System.out.println(bigDecimal.negate());
        System.out.println(bigDecimal.plus());
    }
}
