package com.ds.graphs;

public class Vertex {

	public String data;
	
	public boolean isVisited;
	
	public Vertex(String data) {
		this.data = data;
	}
	
	public void display(){
		System.out.println("Data is "+ this.data);
	}
	
}
