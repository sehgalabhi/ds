package com.ds.list;

import com.ds.list.FirstLastLinkList;

public class FirstLastLinkListTest {

	public static void main(String[] args) {

		FirstLastLinkList linkList = new FirstLastLinkList();
		linkList.insertFirst("A");
		linkList.insertFirst("B");
		linkList.insertFirst("C");
		linkList.insertFirst("D");
		
		linkList.insertLast("Alpha");

		linkList.displayList();

		System.out.println("link --> " + linkList.find("C").getData());

		if (linkList.find("G") != null) {
			System.out.println("link --> " + linkList.find("G").getData());
		}
		linkList.delete("C");
		linkList.displayList();
		linkList.deleteFirst();
		linkList.deleteFirst();

		linkList.displayList();
	}
}
