package com.ds.arrays;

import com.ds.arrays.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue queue = new Queue(10);
		
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
