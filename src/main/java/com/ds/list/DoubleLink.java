package com.ds.list;

public class DoubleLink {

	public String data;

	public DoubleLink next;
	
	public DoubleLink previous;

	public DoubleLink(String data) {
		this.data = data;
	}

	
	public void displayLink(){
		System.out.println("Data is " + data);
	}

}
