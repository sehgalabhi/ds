package com.ds.list;

public class QueueLink {
	private FirstLastLinkList firstLastLinkList = new FirstLastLinkList();
	
	public void insert(String data){
		firstLastLinkList.insertLast(data);
	}
	
	public String remove(){
		return firstLastLinkList.deleteFirst().getData();
		
	}
	
	
}
