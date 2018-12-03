package com.codility;

import java.util.Stack;

public class TStack<T> {

    private Node head;
    private Stack<T> transactions;

    public TStack(Stack<T> transactions) {
        this.transactions = new Stack<>();
    }

    public TStack() {
    }

    public void push(T data){
        Node tNode = new Node(data);
        tNode.next = head;
        head = tNode;

    }

    public T pop (){
        if(head == null ) {
            throw new RuntimeException("no data");
        }
        T data  = head.data;
        head = head.next;
        return data;
    }

    public void begin(T transaction) {

    }


    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }
}
