package com.ds.arrays;

public class Stack {
	
	private double[] stackArr;
	
	private int top;
	
	public Stack(int capacity) {
		stackArr = new double[capacity];
		top = -1;
	}
	
	public void push(double val){
		stackArr[++top] = val;
	
	}
	
	public double pop(){
		return stackArr[top--];
		
	}
	
	public double peek(){
		return stackArr[top];
		
	}
	
	public int size(){
		return top+1;
	}
	
	public void display(){
		for (int i = 0; i < (top+1); i++) {
			System.out.print(stackArr[i] + ",");
			
		}
		System.out.println("Displayed");
	}
}
