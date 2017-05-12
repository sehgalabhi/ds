package com.threads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by asehgal on 5/12/2017.
 */
public class SemaphoreBoundedHashSet<T> {

    private final Set<T> set;
    final Semaphore semaphore;

    public SemaphoreBoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    private boolean add(T o) {
        boolean wasAdded = false;
        try {
            semaphore.acquire();
            wasAdded = set.add(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!wasAdded) {
                semaphore.release();
            }
        }
        return wasAdded;
    }

    boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            semaphore.release();
        }
        return wasRemoved;
    }
}
