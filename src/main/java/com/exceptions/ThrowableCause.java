package com.exceptions;

/**
 * Created by asehgal on 6/22/2017.
 */
public class ThrowableCause {
    public static void main(String[] args) throws Exception {
//        new ThrowableCause().testThrowableInitCause();
//        new ThrowableCause().testThrowableConstructor();
//        new ThrowableCause().testThrowableCause();

        String test = "44435030335C";
        System.out.println(test.trim().matches("444350303[0-2]5C"));

        test = "DCP02";
        System.out.println(test.matches("444350303[0-2]5C"));


        test = "DCP03";
        System.out.println(test.matches("444350303[0-2]5C"));

        test = "dcp01";
        System.out.println(test.matches("444350303[0-2]5C"));

        test = "dsd01";
        System.out.println(test.matches("444350303[0-2]5C"));

        test = "DCP03";
        System.out.println(test.matches("444350303[0-2]5C"));

    }

    private void testThrowableInitCause() throws Exception {
        try {
            test3();
        } catch (Exception e) {
            Exception e1 = new Exception("Excpetion in testThrowableConstructor caused by ");
            e1.initCause(e);
            throw e1;
        }
    }

    private void testThrowableCause() throws Exception {
        try {
            test2();
        } catch (Exception e) {
            throw new Exception("Excpetion in testThrowableConstructor caused by ", e.getCause());
        }
    }

    private void testThrowableConstructor() throws Exception {

        try {
            test1();
        } catch (Exception e) {
            throw new Exception("Excpetion in testThrowableConstructor caused by ", e);
        }

    }

    private void test1() throws Exception {
        throw new Exception("test1 exception");
    }

    private void test2() throws Exception {
        throw new Exception("test2 exception");
    }

    private void test3() throws Exception {
        throw new Exception("test3 exception");
    }

}
