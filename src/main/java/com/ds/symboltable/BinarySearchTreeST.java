package com.ds.symboltable;

import java.util.Optional;

public class BinarySearchTreeST<Key extends Comparable<Key>, Value extends Comparable<Value>> implements SymbolTable<Key, Value> {

    private Optional<Node> root;
    private int size;

    public BinarySearchTreeST() {
        this.root = Optional.empty();
    }

    @Override
    public void put(Key key, Value value) {
        Optional<Node> node = putNode(root, key, value);
        root = node;
        size = 1 + (node.get().left.isPresent() ? 1 : 0) + (node.get().right.isPresent() ? 1 : 0);

    }

    private Optional<Node> putNode(Optional<Node> root, Key key, Value value) {
        if (!root.isPresent()) {
            Node node = new Node(key, value, Optional.empty(), Optional.empty());
            return Optional.of(node);
        }

        if (key.compareTo(root.get().key) < 0) {
            root.get().left = putNode(root.get().left, key, value);
        } else {
            root.get().right = putNode(root.get().right, key, value);
        }

        return root;
    }

    @Override
    public Value get(Key key) {
        Optional<Node> node = findNode(root, key);
        if (node.isPresent()) {
            return node.get().value;
        } else {
            return null;
        }
    }

    private Optional<Node> findNode(Optional<Node> root, Key key) {
        if (!root.isPresent()) {
            return Optional.empty();
        }
        Key rootKey = root.get().key;
        Optional<Node> foundNode = key.compareTo(rootKey) == 0 ? root : key.compareTo(rootKey) < 0 ? findNode(root.get().left, key) : findNode(root.get().right, key);
        return foundNode;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return findNode(root, key).isPresent();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
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
        return "Size: " + size + " " + traverse(root);
    }

    private String traverse(Optional<Node> root) {
        return root.isPresent() ? traverse(root.get().left) + " -> " + root.get() + traverse(root.get().right) : "";
    }

    private class Node {
        private Key key;
        private Value value;
        private Optional<Node> left;
        private Optional<Node> right;
        private int rank;

        public Node(Key key, Value value, Optional<Node> leftTree, Optional<Node> rightTree) {
            this.key = key;
            this.value = value;
            this.left = leftTree;
            this.right = rightTree;
            this.rank = 1;
        }

        public Key getKey() {
            return key;
        }

        @Override
        public String toString() {
            return (key + ":" + value);
        }

        public Value getValue() {
            return value;
        }

        public Optional<Node> getLeft() {
            return left;
        }

        public Optional<Node> getRight() {
            return right;
        }
    }
}


class BinarySearchTreeTest {
    public static void main(String[] args) {
        new BinarySearchTreeTest().test();
    }

    private void test() {
        BinarySearchTreeST binarySearchTreeST = new BinarySearchTreeST();
        binarySearchTreeST.put("M", "1");
        binarySearchTreeST.put("N", "2");
        binarySearchTreeST.put("Z", "3");
        binarySearchTreeST.put("C", "4");

        System.out.println(binarySearchTreeST.contains("C"));
        System.out.println(binarySearchTreeST.get("C"));
        System.out.println(binarySearchTreeST);
    }
}