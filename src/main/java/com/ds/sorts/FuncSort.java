package com.ds.sorts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abhi on 2/4/18.
 */
@FunctionalInterface
public interface FuncSort {

    <T extends Comparable> List<T> sort(List<T> ts);

    default <T extends Comparable> boolean isLess(T first, T second) {
        return first.compareTo(second) < 0;
    }

    default <T extends Comparable> T[] exchange(T[] arr, int toBeReplaced, int toReplace) {
        T temp = arr[toBeReplaced];
        arr[toBeReplaced] = arr[toReplace];
        arr[toReplace] = temp;
        return arr;
    }
}

class SelectionSort implements FuncSort {

    @Override
    public <T extends Comparable> List<T> sort(List<T> ts) {
        T[] inputArray = ts.toArray((T[]) new Comparable[ts.size()]);

        for (int i = 0; i < inputArray.length; i++) {
            int minIndex = i;
            for (int j = minIndex; j < inputArray.length; j++) {
                if (isLess(inputArray[j], inputArray[minIndex])) {
                    minIndex = j;
                }
            }
            exchange(inputArray, i, minIndex);
        }

        return Arrays.asList(inputArray);
    }

}

class InsertionSort implements FuncSort {

    @Override
    public <T extends Comparable> List<T> sort(List<T> ts) {
        T[] inputArray = ts.toArray((T[]) new Comparable[ts.size()]);

        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j >= 1; j--) {
                if (isLess(inputArray[j], inputArray[j - 1])) {
                    exchange(inputArray, j, j - 1);
                }
            }
        }
        return Arrays.asList(inputArray);
    }
}

class HeapSort implements FuncSort {
    @Override
    public <T extends Comparable> List<T> sort(List<T> ts) {
        T[] inputArray = ts.toArray((T[]) new Comparable[ts.size()]);

        int midIndex = inputArray.length / 2;

        for (int currentTreeIndex = midIndex; currentTreeIndex >= 1; currentTreeIndex--) {
            sortWithEffectiveArrayIndex(inputArray, currentTreeIndex, inputArray.length);
            int rootIndex = currentTreeIndex;
            if (rootIndex <= midIndex/2) {
                rootIndex++;
                sinkRoot(inputArray, midIndex, rootIndex, inputArray.length);
            }
        }
        int arraySize = inputArray.length;
        while (arraySize > 1){
            exchange(inputArray, 0, arraySize-1);
            arraySize--;
            sinkRoot(inputArray, arraySize);
        }


        return Arrays.asList(inputArray);
    }

    private <T extends Comparable> void sinkRoot(T[] inputArray, int arraySize) {
        int midIndex= arraySize/2;
        sinkRoot(inputArray, midIndex, 1, arraySize);

    }

    private <T extends Comparable> void sinkRoot(T[] inputArray, int midIndex, int rootIndex, int arraySize) {
        while (rootIndex <= midIndex ) {
            sortWithEffectiveArrayIndex(inputArray, rootIndex, arraySize);
            rootIndex++;
        }
    }

    private <T extends Comparable> void sortWithEffectiveArrayIndex(T[] inputArray, int midIndex, int arrayLength) {
        int leftChild = midIndex * 2;
        int rightChild = midIndex * 2 + 1;

        int biggerIndexToCompare =
                (leftChild <= arrayLength) && (rightChild <= arrayLength) ?
                        (isLess(inputArray[leftChild - 1], inputArray[rightChild - 1]) ? rightChild : leftChild)
                        : leftChild > arrayLength? -1 : leftChild;
        if (biggerIndexToCompare != -1  && isLess(inputArray[midIndex - 1], inputArray[biggerIndexToCompare - 1])) {
            exchange(inputArray, midIndex-1, biggerIndexToCompare-1);
        }
    }
}

class Test {
    private static List<Integer> toBeSorted = Arrays.asList(3, 7, 2, 1, 10, 6);

    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
        testSelectionSort();
        testInsertionSort();
        testHeapSort();
    }

    private void testHeapSort() {
        System.out.println("Heap sort");
        String collect = toBeSorted.stream().map(t -> String.valueOf(t)).collect(Collectors.joining(","));
        System.out.println(collect);
        FuncSort funcSort = new HeapSort();
        List<Integer> sorted = funcSort.sort(toBeSorted);
        System.out.println(sorted.stream().map(t -> String.valueOf(t)).collect(Collectors.joining(",")));

    }

    private void testInsertionSort() {
        System.out.println("Insertion sort");
        String collect = toBeSorted.stream().map(t -> String.valueOf(t)).collect(Collectors.joining(","));
        System.out.println(collect);
        FuncSort funcSort = new InsertionSort();
        List<Integer> sorted = funcSort.sort(toBeSorted);
        System.out.println(sorted.stream().map(t -> String.valueOf(t)).collect(Collectors.joining(",")));

    }

    private void testSelectionSort() {
        System.out.println("Selection Sort");
        String collect = toBeSorted.stream().map(t -> String.valueOf(t)).collect(Collectors.joining(","));
        System.out.println(collect);

        FuncSort funcSort = new SelectionSort();
        List<Integer> sorted = funcSort.sort(toBeSorted);
        System.out.println(sorted.stream().map(t -> String.valueOf(t)).collect(Collectors.joining(",")));

    }
}