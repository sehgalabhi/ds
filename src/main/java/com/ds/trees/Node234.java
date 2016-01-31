package com.ds.trees;

public class Node234 {
	DataItem234[] itmArr = new DataItem234[3];

	Node234[] childArr = new Node234[4];

	
	
	public int numItems;
	
	public Node234 parent;
	
	public Node234() {
		// TODO Auto-generated constructor stub
	}
	

	public int findItem(int key){
		for (int i = 0; i < numItems; i++) {
			if(key == itmArr[i].data){
				return itmArr[i].data;
				
			}
		}
		
		return -1;
	}
	
	public void insertItem(int data){
		DataItem234 item = new DataItem234();
		item.data = data;
		for (int i = 0; i < numItems; i++) {
			if(data < itmArr[i].data){
				for (int j = numItems; j > i; j--) {
					itmArr[j] = itmArr[j-1];
				}
				itmArr[i]=item;
			}
		}
		
	}
	
	
	public void removeItem(int data){
		for (int i = 0; i < numItems; i++) {
			if(data == itmArr[i].data){
				for (int j = i; j <numItems; j--) {
					itmArr[j] = itmArr[j+1];
				}
				break;
			}
		}
		
		
	}
	
	public void displayItem(){
		for (int i = 0; i < numItems; i++) {
			itmArr[i].displayData();
		}
	}
}
