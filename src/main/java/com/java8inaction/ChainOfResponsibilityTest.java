package com.java8inaction;

import java.util.function.Function;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        new ChainOfResponsibilityTest().test();
    }

    private void test() {
        testWithoutLambda();
        testWithLambda();

    }

    private void testWithLambda() {

        Function<String, String> header = (input) -> "Header " + input;
        Function<String, String> footer = (input) -> "Footer " + input;
        Function<String, String> stringStringFunction = header.andThen(footer);
        System.out.println(stringStringFunction.apply("Test"));
    }

    private void testWithoutLambda() {
        ProcessingObject<String> p = new HeaderTextProcessingObject();
        ProcessingObject<String> p1 = new FooterProcessingObect();
        p.setSuccessor(p1);
        String test = p.handle("Test");
        System.out.println(test);
    }
}


abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }


    abstract protected T handleWork(T input);
}


class HeaderTextProcessingObject extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "head " + input;
    }
}

class FooterProcessingObect extends ProcessingObject<String>{

    @Override
    protected String handleWork(String input) {
        return "Footer " + input;
    }
}