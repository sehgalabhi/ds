package com.java8inaction;

public class AnonymousVsLambda {
    public static void main(String[] args) {
        new AnonymousVsLambda().test();
    }

    private void test() {
        testThis(); //anonymous, this is same class. but in lambda it is enclosing class
        testLambdaAmbiguityInOverloading();
    }

    private void testLambdaAmbiguityInOverloading() {
        doSomething((Task) () -> {
            System.out.println();
        });
    }

    private void testThis() {
        int a = 10;
        Runnable r = () -> {
            //int a = 2; //will not work as it cannot shadow the variables in enclosing class
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int a =2; //it works
            }
        };

    }

    public void doSomething(Runnable r){
        r.run();
    }

    public void doSomething(Task r){
        r.execute();
    }
}


interface Task {
    public void execute();
}

