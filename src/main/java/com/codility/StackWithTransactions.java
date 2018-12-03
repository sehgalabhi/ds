//package com.codility;
//
//public class StackWithTransactions<T> {
//    private Stack<T> _transactions = new Stack<T>();
//    private Stack<T> _stack = new Stack<>();
//
//
//    public void Push(T data) {
//        if (_transactions.IsEmpty) {
//            _stack.Push(data);
//            return;
//        }
//        _transactions.Top().Push(data);
//    }
//
//    public void Pop() {
//        if (_transactions.IsEmpty) {
//            _stack.Pop();
//            return;
//        }
//        _transactions.Top().Pop();
//
//    }
//
//    public T Top() {
//        return _transactions.IsEmpty ? _stack.Top() : _transactions.Top().Top();
//    }
//
//    public void Begin() {
//        _transactions.Push(new Stack());
//    }
//
//    public bool Rollback() {
//        if (_transactions.IsEmpty) return false;
//        _transactions.Pop();
//        return true;
//    }
//
//    public bool Commit() {
//        if (_transactions.IsEmpty) return false;
//        var transaction = _transactions.Top();
//        _transactions.Pop();
//
//        var innerTransaction = _transactions.IsEmpty
//                ? _stack
//                : _transactions.Top();
//
//        Stack.Append(Stack.Reverse(transaction), innerTransaction);
//
//        return true;
//    }
//}
//
//public class Stack<T> {
//    public Node Head;
//
//
//    public boolean IsEmpty = Head == null;
//    public int Count;
//
//
//    public T Pop() {
//        if (IsEmpty) return null;
//        T data = Head.Data;
//        Head = Head.Next;
//        Count--;
//        return data;
//    }
//
//    public void Push(T data) {
//        Node node = new Node(data);
//        Head = node;
//        Count++;
//    }
//
//    public T Top() {
//        return IsEmpty ? null :Head.Data;
//    }
//
//    public static Stack Reverse(Stack stack) {
//        Stack s = new Stack();
//        while (!stack.IsEmpty) {
//            s.Push(stack.Pop());
//        }
//        return s;
//    }
//
//    public static void Append(Stack src, Stack dst) {
//        while (!src.IsEmpty) {
//            dst.Push(src.Pop());
//        }
//    }
//
//    public class Node {
//        public T Data;
//
//
//        public Node Next;
//
//
//        public Node(T data) {
//            Data = data;
//        }
//    }
//}
//
//
//
//
