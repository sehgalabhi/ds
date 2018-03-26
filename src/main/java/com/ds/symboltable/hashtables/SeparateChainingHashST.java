package com.ds.symboltable.hashtables;

import com.ds.symboltable.SymbolTable;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by abhi on 25/3/18.
 */
public class SeparateChainingHashST<Key extends Comparable<Key>, Value extends Comparable<Value>> implements SymbolTable<Key, Value> {

    private int M = 97;
    private Node[] hashNodes = new Node[M];

    @Override

    public void put(Key key, Value value) {
        int i = hash(key);
        Node toCreate = new Node(key, value);
        Node indexedNodStart = hashNodes[i];
        if (indexedNodStart != null) {
            toCreate.next = indexedNodStart;
        }
        hashNodes[i] = toCreate;


    }

    @Override
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = hashNodes[i]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return (Value) x.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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


    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    static class Node {
        private Object key;
        private Object value;
        private Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return (key + ":" + value + "- >" + (next != null ? next.toString(): null));
        }


    }

    @Override
    public String toString() {
        return Arrays.stream(hashNodes).filter(t -> {
//            System.out.println(t != null);
            return t != null;
        }).collect(Collectors.toList()).toString();
    }
}


class SeparateChainingSTTest {
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> stringIntegerSeparateChainingHashST = new SeparateChainingHashST<>();
        stringIntegerSeparateChainingHashST.put("A", 1);
        stringIntegerSeparateChainingHashST.put("C", 2);
        stringIntegerSeparateChainingHashST.put("Aa", 3);
        stringIntegerSeparateChainingHashST.put("BB", 5);
        System.out.println(stringIntegerSeparateChainingHashST);
        System.out.println(stringIntegerSeparateChainingHashST.contains("A"));
        System.out.println(stringIntegerSeparateChainingHashST.contains("D"));
    }
}