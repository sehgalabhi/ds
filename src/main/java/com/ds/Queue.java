package com.ds;

public class Queue {
	private double[] queue;

	private int front;
	
	private int capacity;

	private int rear;

	private int nElems;

	public Queue(int size) {
		capacity = size;
		queue = new double[size];
		nElems = 0;
		front = 0;
		rear = -1;
	}

	public void insert(double val) {
		if(nElems < capacity ){
			if(rear ==capacity-1 ){
				rear=-1;
			}
			
			queue[++rear] = val;
			nElems++;
		} else{
			System.out.println("Full");
		}
	
		
	}

	public double remove() {
		double val = queue[front++];
		if(front == capacity  ){
			front = 0;
		}
		nElems--;
		return val;
	}

	public double peek() {
		return queue[front];
	}

	public int size() {
		return nElems;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(queue[i] + ",");
		}
		System.out.println("Displayed");
	}

	public boolean isEmpty(){
		
		
		if((rear +1 == front) || (front+ capacity -1 == rear)) {
			return true;
		}
 		
		return false;
	}
	
	public boolean isFull(){
		
		return ( (rear == front+capacity -2) || (rear+2 == front));
		
	}
	
	
}
