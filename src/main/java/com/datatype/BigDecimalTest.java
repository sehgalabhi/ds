package com.datatype;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        new BigDecimalTest().test();
    }

    private void test() {
        BigDecimal bigDecimal = new BigDecimal("1");
        System.out.println(bigDecimal.negate());
        System.out.println(bigDecimal.plus());
    }
}
