package com.coursera.week2.reference;

import java.util.Iterator;

/**
 * Created by asehgal on 5/1/2017.
 */
public class StackWithArray<E> implements Stack<E>, Iterable<E> {

    private E[] arr;

    private int index;

    public StackWithArray(int N) {
        arr = (E[]) new Object[N];
    }

    public void push(E item) {
        arr[index++] = item;
    }

    public E pop() {
        return arr[--index];
    }

    public boolean isEmpty() {

        return index == 0;
    }

    public int size() {
        return index;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int pointer = index;
            public boolean hasNext() {
                return pointer > 0;
            }

            public E next() {
                return arr[--pointer];
            }

            public void remove() {

            }
        };
    }
}
