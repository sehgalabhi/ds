package com.ds.list;

public class ListIterator {

	Link current;

	Link previous;

	LinkList ourList;

	public ListIterator(LinkList ourList) {
		ourList = ourList;
	}

	public void reset() {
		current = ourList.first;
		previous = null;
		
	}
	
	public Link nextLink(){
		previous  = current;
		current = current.getNextLink();
		return current;
	}
	
	public boolean atEnd() {
		return current.getNextLink() == null;
	}
	
	public void insertAfter(String data){
		Link newLink = new Link(data);
		
		if(ourList.isEmpty()){
			ourList.first = newLink;	
			current = newLink;
			reset();
		} else{
			newLink.setNextLink(current.getNextLink());
			current.setNextLink(newLink);
			nextLink();
		}
		
	}
	
	public void insertBefore(String data){
		Link newLink = new Link(data);
		
		if(ourList.isEmpty()){
			ourList.first = newLink;	
			current = newLink;
			reset();
		} else{
			newLink.setNextLink(current);
			previous.setNextLink(newLink);
			current = newLink;
		}
		
	}
	

}
