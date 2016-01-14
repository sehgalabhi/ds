package com.ds.arrays;

import com.ds.arrays.ArrayList;

public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList ls = new ArrayList(10);
		System.out.println(ls.size);
		ls.insert(1);
		ls.insert(10);
		ls.insert(11);
		ls.insert(3);
		ls.insert(9);
		ls.insert(6);
		ls.insert(8);
		
		
		ls.display();
		
		
	//	ls.selectionSort();
		ls.insertionSort();
		ls.display();
	
		ls.delete(5);
		ls.delete(8);
		ls.display();
	//
		//ls.bubbleSort();
		//ls.selectionSort();
		ls.insertionSort();
		System.out.println(ls.find(10));
		System.out.println(ls.find(50));
		
		System.out.println("Sorted");
		ls.display();
		
	}

}
