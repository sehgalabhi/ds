package com.overrides;

/**
 * Created by asehgal on 6/21/2017.
 */
public class OverloadTest {
    public static void main(String[] args) {
        new OverloadTest().test();
    }

    private void test() {
        method1();
        method1(2);
    }

    public void method1(){
        System.out.println("Nothing");
    }

    private void method1(int a){
        System.out.println(String.valueOf(a));
    }

}
