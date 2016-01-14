package com.ds.list;

public class StackLink {
	private FirstLastLinkList firstLastLinkList = new FirstLastLinkList();
	
	public void push(String data){
		firstLastLinkList.insertFirst(data);
	}
	
	public String pop(){
		return firstLastLinkList.deleteFirst().getData();
		
	}
	
	
}
