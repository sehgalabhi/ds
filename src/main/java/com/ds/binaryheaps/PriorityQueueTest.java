package com.ds.binaryheaps;

import java.util.Arrays;

public class PriorityQueueTest {

    public static void main(String[] args) {
        new PriorityQueueTest().test();
    }

    private void test() {
        testPQBinaryHeap();
        testPQUnOrdered();

    }

    private void testPQUnOrdered() {
        MaxPQUnOrderedArray<String> stringMaxPQUnOrderedArray = new MaxPQUnOrderedArray<>();
        stringMaxPQUnOrderedArray.insert("M");
        stringMaxPQUnOrderedArray.insert("A");
        stringMaxPQUnOrderedArray.insert("C");
        stringMaxPQUnOrderedArray.insert("B");
        stringMaxPQUnOrderedArray.insert("D");
        stringMaxPQUnOrderedArray.insert("T");
        stringMaxPQUnOrderedArray.insert("S");

        String delMax = stringMaxPQUnOrderedArray.delMax();
        System.out.println(delMax);
        String delMax1 = stringMaxPQUnOrderedArray.delMax();
        System.out.println(delMax1);


        System.out.println(stringMaxPQUnOrderedArray);
    }

    private void testPQBinaryHeap() {
        MaxPQBinaryHeap<String> stringMaxPQBinaryHeap = new MaxPQBinaryHeap<>();
        stringMaxPQBinaryHeap.insert("M");
        stringMaxPQBinaryHeap.insert("A");
        stringMaxPQBinaryHeap.insert("C");
        stringMaxPQBinaryHeap.insert("B");
        stringMaxPQBinaryHeap.insert("D");
        stringMaxPQBinaryHeap.insert("T");
        stringMaxPQBinaryHeap.insert("S");

        String delMax = stringMaxPQBinaryHeap.delMax();
        System.out.println(delMax);
        String delMax1 = stringMaxPQBinaryHeap.delMax();
        System.out.println(delMax1);


        System.out.println(stringMaxPQBinaryHeap);
    }
}

class MaxPQBinaryHeap<T extends Comparable<T>> {

    private int MAX_ELEMS = 10;
    private T[] values;
    private int N;

    @Override
    public String toString() {
        return "MaxPQBinaryHeap{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    public MaxPQBinaryHeap(T[] values) {
        this.values = values;
    }

    public MaxPQBinaryHeap() {
        values = (T[]) new Comparable[MAX_ELEMS];
    }

    public void insert(T val) {
        values[++N] = val;
        swim(N);
    }

    private void swim(int lastIndex) {
        while (lastIndex > 1 && values[lastIndex / 2].compareTo(values[lastIndex]) < 0) {
            exch(lastIndex / 2, lastIndex);
            swim(lastIndex / 2);
        }
    }

    public T delMax() {
        T returnVal = values[1];
        sink(1);
        values[N--] = null;
        return returnVal;
    }

    private int sink(int startIndex) {
        while (startIndex != -1 && startIndex < N) {
            int indexToReplace = findValueToExchange(startIndex);
            exch(indexToReplace, startIndex);
            startIndex = sink(indexToReplace);
        }
        return -1;
    }

    private int findValueToExchange(int startIndex) {
        if(startIndex*2 == N){
            return startIndex*2;
        }
        int maxChild = values[2 * startIndex].compareTo(values[(2 * startIndex + 1)]) < 0 ? (2 * startIndex + 1) : 2 * startIndex;

        return maxChild;
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int size() {
        return values.length;
    }

    private void exch(int maxIndex, int lastIndex) {
        T tmp = values[maxIndex];
        values[maxIndex] = values[lastIndex];
        values[lastIndex] = tmp;

    }


}


class MaxPQUnOrderedArray<T extends Comparable<T>> {

    private int MAX_ELEMS = 100;
    private T[] values;
    private int N;
    @Override
    public String toString() {
        return "MaxPQBinaryHeap{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    public MaxPQUnOrderedArray(T[] values) {
        this.values = values;
    }

    public MaxPQUnOrderedArray() {
        values = (T[]) new Comparable[MAX_ELEMS];
    }

    public void insert(T val) {
        values[N++] = val;
    }

    public T delMax() {
        T max = values[0];
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (isLess(max, values[i])) {
                max = values[i];
                index = i;
            }
        }
        exch(index, N - 1);

        return values[--N];
    }

    private void exch(int maxIndex, int lastIndex) {
        T tmp = values[maxIndex];
        values[maxIndex] = values[lastIndex];
        values[lastIndex] = tmp;

    }

    private boolean isLess(T val1, T val2) {
        return val1.compareTo(val2) < 0;
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int getSize() {
        return values.length;
    }


}

class MaxPQOrderedArray<T extends Comparable<T>> {

    private int MAX_ELEMS = 100;
    private T[] values;
    private int N;
    @Override
    public String toString() {
        return "MaxPQBinaryHeap{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    public MaxPQOrderedArray(T[] values) {
        this.values = values;
    }

    public MaxPQOrderedArray() {
        values = (T[]) new Comparable[MAX_ELEMS];
    }

    public void insert(T val) {
        int valIndex = findIndex(val);
        moveAll(valIndex);
        values[valIndex] = val;
    }

    private void moveAll(int valIndex) {
        for (int i = N; i > N; i--) {
            values[N] = values[N - 1];
        }
    }

    private int findIndex(T val) {
        int startIndex = 0;
        for (int i = 0; i < N; i++) {
            if (val.compareTo(values[i]) < 0) {
                startIndex = i;
            }
        }
        return startIndex;
    }

    public T delMax() {
        return values[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


}