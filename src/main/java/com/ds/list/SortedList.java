package com.ds.list;

public class SortedList {
	private Link first;

	public boolean isEmpty() {
		return (first == null);
	}

	public void insert(String data) {
		Link newLink = new Link(data);
		Link current = first;
		Link previous = null;
		
		if(first == null){
			first = newLink;
			
		}
		
		while(current != null){
			if(data.length() < current.getData().length()){
				current.setNextLink(current);
				previous.setNextLink(newLink);
				break;
			} else{
				previous = current;
				current.setNextLink(current);
			}
			
			
		}
		
		
	}

	public void deleteFirst() {
		first = first.getNextLink();
	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.getNextLink();

		}
	}

	public Link find(String key) {

		Link link = null;
		Link current = first;
		while (current != null) {
			if (current.getData().equalsIgnoreCase(key)) {
				link = current;
				break;
			}
			current = current.getNextLink();
		}
		return link;
	}

	public void delete(String key) {
		Link current = first;
		Link previous = null;
		while (current != null) {
			if (current.getData().equalsIgnoreCase(key)) {
				if (previous == null) {
					first = current.getNextLink();
				} else {
					previous.setNextLink(current.getNextLink());
				}
				break;
			}
			previous = current;
			current = current.getNextLink();

		}

	}
}
