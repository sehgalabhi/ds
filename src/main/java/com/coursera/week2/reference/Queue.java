package com.coursera.week2.reference;

/**
 * Created by asehgal on 5/1/2017.
 */
public interface Queue {

    void enqueue(String item);

    String dequeue();

    boolean isEmpty();

    int size();
}
