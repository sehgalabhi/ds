package com.coursera.week2.reference;


public class StackTest {

    public static void main(String[] args) {
        testStackArray();
        //testStackList();



    }

    private static void testStackArray() {
        Stack<Integer> stack = new StackWithArray<Integer>(20);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(11);
        stack.push(43);


        for (Integer integer : stack) {
            System.out.println(integer);
        }
        //stack.display();

        while (stack.size() > 0) {
            System.out.println("Pop--->" + stack.pop());
        }

        Stack<String> stackString = new StackWithArray(20);
        stackString.push("One");
        stackString.push("Two");
        stackString.push("Three");


        //stack.display();
        for (String string : stackString) {
            System.out.println(string);
        }
        while (stackString.size() > 0) {
            System.out.println("Pop--->" + stackString.pop());
        }
    }

    private static void testStackList() {
        Stack<Integer> stack = new StackWithList();
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(11);
        stack.push(43);

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        //stack.display();

        while (stack.size() > 0) {
            System.out.println("Pop--->" + stack.pop());
        }

        Stack<String> stackString = new StackWithList();
        stackString.push("One");
        stackString.push("Two");
        stackString.push("Three");


        //stack.display();
        for (String string : stackString) {
            System.out.println(string);
        }
        while (stackString.size() > 0) {
            System.out.println("Pop--->" + stackString.pop());
        }
    }

}
