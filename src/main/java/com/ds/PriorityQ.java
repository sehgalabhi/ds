package com.ds;

public class PriorityQ {
	private double[] queue;


	
	private int capacity;

	private int nElems;

	public PriorityQ(int size) {
		capacity = size;
		queue = new double[size];
		nElems = 0;

		
	}

	public void insert(double val) {
		// front remains at same position
		// element is checked , if its smaller than front, elements are moved ahead
		
		

		if(nElems < capacity ){		
			int position =0;
			for (int i = nElems-1; i >= 0; i--) {
				if(val < queue[i]){
					queue[i+1] =queue[i];					
				} else{
					position = i+1;
					break;
				}
			}
			queue[position]=val;
			nElems++;
		} else{
			System.out.println("Full");
		}
	
		
	}

	public double remove() {
		double val = queue[0];
		for (int i = 0; i < nElems; i++) {
			queue[i] =queue[i+1];
		}
		nElems--;
		return val;
	}

	public double peek() {
		return queue[0];
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

/*	public boolean isEmpty(){
		
		
		if((rear +1 == front) || (front+ capacity -1 == rear)) {
			return true;
		}
 		
		return false;
	}*/
	
/*	public boolean isFull(){
		
		return ( (rear == front+capacity -2) || (rear+2 == front));
		
	}*/
	
	
}
