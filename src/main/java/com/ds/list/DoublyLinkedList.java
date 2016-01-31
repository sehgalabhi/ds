package com.ds.list;

public class DoublyLinkedList {

	private DoubleLink first;

	private DoubleLink last;

	public DoublyLinkedList() {

	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(String data) {
		DoubleLink newLink = new DoubleLink(data);
		if (isEmpty()) {
			last = newLink;
		} else {

			first.previous = newLink;

		}
		newLink.next = first;
		first = newLink;

	}

	public void insertLast(String data) {
		DoubleLink newLink = new DoubleLink(data);

		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}

		last = newLink;

	}

	public void deleteFirst() {
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		first.previous = null;
	}

	public void deleteLast() {
		if (last.previous == null) {
			first = null;
		}

		last = last.previous;
		last.next = null;

	}

	public void insertAfter(String key, String data) {
		DoubleLink newLink = new DoubleLink(data);

		DoubleLink current = first;

		while (current != null & current.data != key) {
			current = current.next;
		}

		if (current != null) {
			if (current == last) {
				newLink.next = null;
				last = newLink;
			} else {
				newLink.next = current.next;
				current.next.previous = newLink;
			}

			newLink.previous = current;

			current.next = newLink;

		}
	}

	public void deleteKey(String key) {
		DoubleLink current = first;

		while (current != null & current.data != key) {
			current = current.next;
		}

		if (current != null) {
			if(current == first){
				current.next.previous = null;
				first = current.next;
				
			} else if(current == last){
				last.previous.next = null;
				last = current.previous;
			} else{
				current.previous.next = current.next;
				current.next.previous = current.previous;
			}
		}
	}

	public void displayForward() {
		DoubleLink current = first;

		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

	public void displayBackward() {
		DoubleLink current = last;

		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
	}

}
