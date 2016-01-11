package com.ds;

public class StackReversorAndDelimiterMatching {
	
	private char[] stackArr;
	
	private int top;
	
	public StackReversorAndDelimiterMatching(int capacity) {
		stackArr = new char[capacity];
		top = -1;
	}
	
	public void push(char val){
		stackArr[++top] = val;
	
	}
	
	public char pop(){
		return stackArr[top--];
		
	}
	
	public char peek(){
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
