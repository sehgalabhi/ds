package com.codility.transStack;

import java.util.Stack;

public class Solution<T> {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1_000_000_000;
    private Stack<T> internalStack = new Stack<>();
    private Stack<Stack<T>> transactions = new Stack<>();

    public Solution() {
        // write your code in Java SE 8
    }

    public void push(T value) {

        if (transactions.isEmpty()) {
            internalStack.push(value);
        } else {
            transactions.peek().push(value);
        }
    }

    public T top() {
        T retVal = null;
        if (transactions.isEmpty()) {
            retVal = topInternal(internalStack);
        } else {
            Stack<T> peek = transactions.peek();
            retVal = topInternal(peek);
        }
        return retVal;
    }

    public void pop() {
        if (!internalStack.isEmpty()) {
            internalStack.pop();
        }
    }

    public void begin() {
        transactions.push(new Stack<T>());
    }

    public boolean rollback() {
        if (!isTransactionInProgress()) {
            return false;
        }

        transactions.pop();
        return true;

    }


    public boolean commit() {
        if (!isTransactionInProgress()) {
            return false;
        }
        Stack<T> poppedTransaction = transactions.pop();
        if (transactions.isEmpty()) {
            internalStack.addAll(poppedTransaction);
        } else {
            transactions.peek().addAll(poppedTransaction);
        }
        return true;
    }

   /* public static void test() {
        // Define your tests here
        Solution sol = new Solution();
        sol.push(42);
        assert sol.top() == 42 : "top() should be 42";
    }
*/
    private boolean isTransactionInProgress() {
        boolean isTransactionInProgress = false;
        if (!transactions.isEmpty()) {
            isTransactionInProgress = true;
        }
        return isTransactionInProgress;
    }

    private T topInternal(Stack<T> internalStack) {
        T retVal = null;
        if (!internalStack.isEmpty()) {
            retVal = internalStack.peek();
        }
        return retVal;
    }

    /*private class Stack<T> {





        public class Node {
            public T Data;


            public Node Next;


            public Node(T data) {
                Data = data;
            }
        }
    }
*/
};