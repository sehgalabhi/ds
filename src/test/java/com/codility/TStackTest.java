package com.codility;

import junit.framework.TestCase;

public class TStackTest extends TestCase{

    public void testOne() {

        TStack<Integer> integerTStack = new TStack<>();
        integerTStack.push(1);
        integerTStack.push(2);
        integerTStack.push(3);

        System.out.println(integerTStack.pop());
        System.out.println(integerTStack.pop());
        System.out.println(integerTStack.pop());
    }

    public void testTwo() {

    }

    public void testThree() {

    }

    public void testFour() {

    }
}
