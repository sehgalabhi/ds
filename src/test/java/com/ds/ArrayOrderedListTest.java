package com.ds;

public class ArrayOrderedListTest {
	
	public static void main(String[] args) {
		ArrayOrderedList ls = new ArrayOrderedList(10);
		System.out.println(ls.size);
		ls.insert(1);
		ls.insert(10);
		ls.insert(11);
		ls.insert(3);
		ls.insert(9);
		ls.insert(6);
		ls.insert(8);
		
		
		ls.display();
		
		System.out.println(ls.find(10));
		System.out.println(ls.find(50));
		
		
		ls.delete(10);
		ls.delete(5);
		ls.delete(8);
		ls.display();
		ls.bubbleSort();
		System.out.println("Sorted");
		ls.display();
		
	}

}
