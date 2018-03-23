package com.ds.symboltable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface SymbolTable<Key extends Comparable<Key>, Value extends Comparable<Value>> {

    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    Key select(int k);

    void deleteMin();

    void deleteMax();

    int size(Key lo, Key hi);

    Iterable<Key> keys(Key lo, Key hi);

    Iterable<Key> keys();


}