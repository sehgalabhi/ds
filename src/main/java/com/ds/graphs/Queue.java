package com.ds.graphs;

public class Queue {

	int rear = -1;
	int front = 0;
	int max = 10;
	int nElems;
	private int[] queueArray;

	public Queue() {
		queueArray = new int[max];
	}

	public void add(int data) {
		if ((!isFull())) {
			if (++rear == max - 1) {
				rear = 0;
			}
			queueArray[rear] = data;
			nElems++;
		}

	}

	public int remove() {
		int val = queueArray[front++];
		if (front == max) {
			front = 0;
		}
		nElems--;
		return val;
	}

	public int peek() {
		return queueArray[front];
	}

	// 4
	// 3
	// 2front
	// 1rear
	// 0
	public boolean isEmpty() {
		return nElems==0;
	}

	public boolean isFull() {
		return nElems==max;
	}

}
