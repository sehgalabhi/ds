package com.exceptions;

import sun.reflect.Reflection;

public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        new ClassNotFoundExceptionExample().test();
    }

    private void test() {
        try {
            Class<?> aClass = Class.forName("oracle.jdbc.driver.OracleDriver");
            aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {


        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
