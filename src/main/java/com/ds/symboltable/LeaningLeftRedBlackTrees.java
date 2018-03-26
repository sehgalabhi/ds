package com.ds.symboltable;

import java.util.Optional;

/**
 * Created by abhi on 24/3/18.
 */
public class LeaningLeftRedBlackTrees<Key extends Comparable<Key>, Value extends Comparable<Value>>
        implements SymbolTable<Key, Value> {

    private Optional<Node> root;
    private int N;

    public LeaningLeftRedBlackTrees() {
        root = Optional.empty();
    }

    public void put(Key key, Value value) {
        Optional<Node> node = putNode(root, Optional.empty(), key, value);
        root = node;
        node.get().isRed = false;
    }

    private Optional<Node> putNode(Optional<Node> root, Optional<Node> parentRoot,
                                   Key key, Value value) {
        if (!root.isPresent()) {
            Node node = new Node(key, value);
            node.rank = 1;

            root = Optional.of(node);
            return root;
        }

        Node rootNode = root.get();
        Optional<Node> newNode = Optional.empty();
        if (key.compareTo(rootNode.key) < 0) {
            newNode = putNode(rootNode.leftTree, Optional.of(rootNode), key, value);
            rootNode.leftTree = newNode;
        } else {
            newNode = putNode(rootNode.rightTree, Optional.of(rootNode), key, value);
            rootNode.rightTree = newNode;
        }

        Optional<Node> returnedNode = balanceTree(newNode.get(), rootNode);
        return returnedNode;

    }

    private Optional<Node> balanceTree(Node newNode, Node parent) {
        Optional<Node> returnedNode = Optional.empty();
        if (isTreeStateInvariantMaintained(newNode, parent)) {
            return Optional.of(parent);
        }

        if (isTreeRightLean(newNode, parent)) {
            returnedNode = rotateLeft(newNode, parent);
            if (areTwoLeftLeaningLinksRed(parent, parent.leftTree)) {
                moveMiddleNodeUp(parent.leftTree.get(), parent, newNode);
                returnedNode = Optional.of(parent);
                flipColors(parent.leftTree.get(), parent, newNode);
            }
            // TODO: 24/3/18 take care of two left leanings
        }

        if (isTreeDoubleRightLean(newNode, parent)) {
            rotateDoubleLeft(newNode, parent);
            moveMiddleNodeUp(parent.leftTree.get(), parent, newNode);
            returnedNode = Optional.of(parent);
            flipColors(parent.leftTree.get(), parent, newNode);
        }

//        if (areTwoLeftLeaningLinksRed(newNode, parent)) {
//            moveMiddleNodeUp(newNode);
//        }

        return returnedNode;
    }

    private void flipColors(Node node1, Node node, Node parent) {
        node1.isRed = false;
        node.isRed = true;
        parent.isRed = false;

    }

    private void moveMiddleNodeUp(Node left, Node middle, Node right) {
        right.leftTree = middle.rightTree;
        middle.rightTree = Optional.of(right);

    }

    private Optional<Node> rotateLeft(Node newNode, Node parent) {
        newNode.leftTree = Optional.of(parent);
        //parent.leftTree = Optional.empty();
        parent.rightTree = Optional.empty();
        parent.isRed = true;
        newNode.isRed = false;
        return Optional.of(newNode);
    }

    private Optional<Node> rotateDoubleLeft(Node newNode, Node parent) {
        newNode.leftTree = Optional.of(parent);
        //parent.leftTree = Optional.empty();
        parent.rightTree = Optional.empty();
        parent.isRed = true;
        newNode.isRed = true;
        return Optional.of(newNode);
    }


    private boolean areTwoLeftLeaningLinksRed(Node parent, Optional<Node> childNode) {
        return childNode.isPresent() && childNode.get().isRed && parent.isRed;
    }

    private boolean isTreeRightLean(Node newNode, Node parent) {
        return !parent.isRed && parent.key.compareTo(newNode.key) < 0;
    }

    private boolean isTreeDoubleRightLean(Node newNode, Node parent) {
        return parent.isRed && parent.key.compareTo(newNode.key) < 0;
    }

    private boolean isTreeStateInvariantMaintained(Node newNode, Node parent) {
        return !parent.isRed && parent.key.compareTo(newNode.key) > 0;
    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    public Key floor(Key key) {
        return null;
    }

    public Key ceiling(Key key) {
        return null;
    }

    public Key select(int k) {
        return null;
    }

    public void deleteMin() {

    }

    public void deleteMax() {

    }

    public int size(Key lo, Key hi) {
        return 0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public String toString() {
        return "Size: " + N + " " + traverse(root);
    }

    private String traverse(Optional<Node> root) {
        return root.isPresent() ? traverse(root.get().leftTree) + " -> " + root.get() + traverse(root.get().rightTree) : "";
    }

    class Node {
        private Key key;
        private Value value;
        private Optional<Node> leftTree;
        private Optional<Node> rightTree;
        private boolean isRed;
        private int rank;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.leftTree = Optional.empty();
            this.rightTree = Optional.empty();
            this.isRed = true;
        }

        @Override
        public String toString() {
            return (isRed + "#" + key + ":" + value);
        }

    }
}


class RedBlackSearchTreeTest {
    public static void main(String[] args) {
        new RedBlackSearchTreeTest().test();
    }

    private void test() {
        LeaningLeftRedBlackTrees redBlackSearchTreeTest = new LeaningLeftRedBlackTrees();
//        redBlackSearchTreeTest.put("S", "1");
//        redBlackSearchTreeTest.put("B", "2");
//        redBlackSearchTreeTest.put("Z", "3");
//        redBlackSearchTreeTest.put("C", "4");
//        redBlackSearchTreeTest.put("D", "4");

        redBlackSearchTreeTest.put("C", "1");
        redBlackSearchTreeTest.put("A", "2");
        redBlackSearchTreeTest.put("B", "3");


//        System.out.println(redBlackSearchTreeTest.contains("C"));
//        System.out.println(redBlackSearchTreeTest.get("C"));
        System.out.println(redBlackSearchTreeTest);
    }
}