package com.coursera.week2.reference;

import java.util.Iterator;

/**
 * Created by asehgal on 5/1/2017.
 */
public interface Stack<E> extends Iterable<E>{

    void push(E item);

    E pop();

    boolean isEmpty();

    int size();

}
