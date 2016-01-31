package com.ds.trees;

public class Node {
	
	public int data;
	
	public Node leftChild;
	
	public Node rightChild;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void displayNode(){
		System.out.println("Data is " + data);
	}

}
