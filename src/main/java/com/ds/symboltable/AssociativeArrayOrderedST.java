package com.ds.symboltable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class AssociativeArrayOrderedST<Key extends Comparable<Key>, Value extends Comparable<Value>> implements SymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public AssociativeArrayOrderedST() {
        keys = (Key[]) new Comparable[20];
        values = (Value[]) new Comparable[20];
    }

    @Override
    public void put(Key key, Value value) {
        int searchIndex = binarySearch(key, 0, N - 1);
        if (searchIndex != -1) {
            values[searchIndex] = value;
            return;
        }
        int putIndex = findIndex(key);
        moveAhead(putIndex);
        keys[putIndex] = key;
        values[putIndex] = value;
        N++;

    }

    private void moveAhead(int putIndex) {
        for (int i = N; i > putIndex; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }

    }

    private int findIndex(Key key) {
        for (int i = 0; i < N; i++) {
            if (key.compareTo(keys[i]) < 0) {
                return i;
            }
        }
        return N;
    }

    @Override
    public Value get(Key key) {
        int searchIndex = binarySearch(key, 0, N - 1);

        return searchIndex != -1 ? values[searchIndex] : null;
    }

    private int binarySearch(Key key, int lowIndex, int highIndex) {
        if (N == 0) return -1;
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;
        if ((highIndex - lowIndex) / 2 == 0) {
            if (keys[lowIndex].compareTo(key) == 0) return lowIndex;
            if (keys[highIndex].compareTo(key) == 0) return highIndex;
            return -1;
        }
        return key.compareTo(keys[midIndex]) == 0 ? midIndex :
                key.compareTo(keys[midIndex]) < 0 ? binarySearch(key, lowIndex, midIndex) :
                        binarySearch(key, midIndex, highIndex);
    }

    public int rank(Key key) {
        int searchIndex = binarySearch(key, 0, N - 1);
        return N - 1 - searchIndex;
    }

    @Override
    public void delete(Key key) {
        put(key, null);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return keys.length == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public String toString() {
        return "AssociativeArrayOrderedST{" +
                "keys=" + Arrays.toString(keys) +
                ", values=" + Arrays.toString(values) +
                ", N=" + N +
                '}';
    }
}


class AssociativeArraySymbolTableTest {
    public static void main(String[] args) throws IOException {
        new AssociativeArraySymbolTableTest().test();
    }

    private void test() throws IOException {
        AssociativeArrayOrderedST<String, String> test = new AssociativeArrayOrderedST<>();
        Path paths = Paths.get("testfile.properties");
        System.out.println(paths.toAbsolutePath());
        Stream<String> lines = Files.lines(paths);
        int[] i = {0};
        lines.forEach(value -> test.put(value, String.valueOf(i[0]++)));


        System.out.println(test.contains("Q"));
        System.out.println(test.contains("A"));
        System.out.println(test.contains("X"));

        System.out.println(test.rank("M"));


//        System.out.println(lines.collect(Collectors.joining(",")));

        System.out.println(test);
    }
}