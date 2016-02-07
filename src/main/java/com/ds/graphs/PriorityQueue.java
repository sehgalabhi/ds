package com.ds.graphs;

public class PriorityQueue {

	private Edge queArray[];

	private int nElems;

	private int MAX = 20;

	public PriorityQueue() {
		queArray = new Edge[MAX];
	}

	public void insert(Edge item) {
		int i = 0;
		for (; i < nElems; i++) {
			if (item.distance < queArray[i].distance) {
				for (int j = nElems; j > i; j--) {
					queArray[j] = queArray[j - 1];
				}
				break;
			}

		}
		queArray[i] = item;
		nElems++;
	}

	public Edge removeMin() {
		Edge min = queArray[0];
		for (int i = 0; i < nElems - 1; i++) {
			queArray[i] = queArray[i + 1];
		}
		nElems--;
		return min;
	}

	public boolean isEmpty() {
		return nElems == 0;
	}

	public Edge peekMin() {
		return queArray[0];
	}

	public int size() {
		return nElems;
	}

	public int find(int destVert) {
		int search = -1;
		for (int i = 0; i < nElems; i++) {
			if (queArray[i].destVert == destVert) {
				search = i;
				break;
			}
		}
		return search;
	}

	public Edge peekN(int n) {
		return queArray[n];
	}

	public void removeN(int n) {
		for (int i = 0; i < nElems - 1; i++) {
			queArray[i] = queArray[i + 1];
		}
		nElems--;
	}

}
