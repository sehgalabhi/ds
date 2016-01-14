package com.ds.arrays;

import com.ds.arrays.PriorityQ;

public class PriorityQTest {
	public static void main(String[] args) {
		PriorityQ queue = new PriorityQ(10);
		
		queue.insert(10);
		queue.insert(5);
		queue.insert(20);
		queue.insert(30);
		queue.insert(7);
		
		queue.display();
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		queue.display();
		queue.insert(70);
		queue.display();
	}

}
