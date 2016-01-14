package com.ds.list;

public class Link {

	private String data;

	private Link nextLink;

	public Link(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Link getNextLink() {
		return nextLink;
	}

	public void setNextLink(Link nextLink) {
		this.nextLink = nextLink;
	}
	
	public void displayLink(){
		System.out.println("Data is " + data);
	}

}
