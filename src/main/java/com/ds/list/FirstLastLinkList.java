package com.ds.list;

public class FirstLastLinkList {

		private Link first;
		
		private Link last;
		
		public boolean isEmpty(){
			return (first == null);
		}
		
		public void insertFirst(String data){
			Link newLink = new Link(data);
			if(isEmpty()){
				last = newLink;
			}
			newLink.setNextLink(first); 
			first = newLink;
		}
		
		public void insertLast(String data){
			Link newLink = new Link(data);
			if(isEmpty()){
				first = newLink;
			} else{
				last.setNextLink(newLink); 
			}
			last = newLink;
			
		}
		
		public Link deleteFirst(){
			Link temp = first;
			if(first.getNextLink() == null){
				last = null;
			}
			first = first.getNextLink();
			return temp;
		}
		
		public void displayList(){
			Link current = first;
			while ( current != null){
				current.displayLink();
				current = current.getNextLink();
				
			}
		}
		
		public Link find(String key){
			
			Link link = null;
			Link current = first;
			while(current != null){
				if(current.getData().equalsIgnoreCase(key)){
					link = current;
					break;
				}
				current = current.getNextLink();
			}
			return link;
		}
		
		public void delete(String key){
			Link current = first;
			Link previous = null;
			while(current != null){
				if(current.getData().equalsIgnoreCase(key)){
					if(previous == null ){
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
