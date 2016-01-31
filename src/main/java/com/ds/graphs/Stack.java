package com.ds.graphs;

public class Stack {

	private int[] stackArray ;
	
	private int numElemens;
	
	public Stack() {
		stackArray = new int[10];
	}
	
	
	public void push(int data){
		stackArray[numElemens++] = data;
	}
	
	public int pop(){
		return stackArray[numElemens--];
	}
	
	public int peek(){
		return stackArray[numElemens -1];
	}
	
	public int size(){
		return numElemens;
	}
	
	
}
