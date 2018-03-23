package com.ds.binaryheaps;

import java.util.Arrays;

public class HeapOrder {


    public static void main(String[] args) {
        new HeapOrder().test();
    }

    private void test() {
        String[] values = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

        System.out.println(Arrays.toString(values));
        buildHeapSortedArray(values);
        System.out.println(Arrays.toString(values));
        createSortedUnheapedArray(values);
        System.out.println(Arrays.toString(values));
    }

    private void createSortedUnheapedArray(String[] values) {
        int index = values.length;
        while (index > 0){
            exchange(0, index-1, values);
            sink(1, values, --index);
            System.out.println(Arrays.toString(values));

        }

    }

    private void buildHeapSortedArray(String[] values) {
        int heapNumber = values.length / 2;
        while (heapNumber > 0) {
            sink(heapNumber, values, values.length);
            heapNumber --;
        }
    }

    private void sink(int heapNumber, String[] values, int length) {
        while(heapNumber <= length/2){
            int biggerChildIndex = findBiggerChildIndex(heapNumber, values, length);
            if (isLess(values[heapNumber-1], values[biggerChildIndex])){
                exchange(heapNumber-1, biggerChildIndex, values);
            }
            heapNumber++;
        }

    }

    private void exchange(int heapNumber, int biggerChildIndex, String[] values) {
        String temp = values[heapNumber];
        values[heapNumber]  =  values[biggerChildIndex];
        values[biggerChildIndex] = temp;
    }

    private boolean isLess(String parent, String child) {
        return parent.compareTo(child) <0;
    }

    private int findBiggerChildIndex(int heapNumber, String[] values, int length) {
        if(2*heapNumber + 1  >= length){
            return 2*heapNumber -1;
        }
        return values[2 * heapNumber-1].compareTo(values[2 * heapNumber]) < 0 ? 2 * heapNumber  : 2 * heapNumber -1;
    }



}
