package com.coursera.week2.reference;

import java.util.Iterator;

/**
 * Created by asehgal on 5/1/2017.
 */
public class StackWithList<E> implements Stack<E>, Iterable<E> {

    private int size;

    private Node first;

    public void push(E item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = first;

        first = newNode;
        size++;
    }

    public E pop() {
        if (null == first) {
            throw new ArrayIndexOutOfBoundsException("no elements");
        }
        E item = first.item;
        first = first.prev;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return null == first;
    }

    public int size() {
        return size;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = first;

            public boolean hasNext() {
                return null != current;
            }

            public E next() {
                E item = current.item;
                current = current.prev;
                return item;
            }

            public void remove() {
                //not supported
            }
        };
    }

    private class Node {
        private E item;
        private Node prev;
    }

}
