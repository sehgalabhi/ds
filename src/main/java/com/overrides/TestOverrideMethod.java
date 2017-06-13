package com.overrides;

/**
 * Created by asehgal on 6/8/2017.
 */
public class TestOverrideMethod {

    public static void main(String[] args) {
        new TestOverrideMethod().test();
    }

    private void test() {
    A a = new A();
    a.sum();

    a = new B();
    a.sum();


    a= new C();
    a.sum();
    }
}


class A{
    void add(){
        System.out.println("in add method ");
        sum();
    }

    protected void sum() {
        System.out.println("in sum method of A"  );
    }
}

class B extends A{
    @Override
    protected void sum() {
        System.out.println("First in sum method of B");

    }
}

class C extends A{
    void subtract(){
        System.out.println("In subtract method of C");
    }
}