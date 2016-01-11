package com.ds;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack(30);
		stack.push(5);
		stack.push(7);
		stack.push(9);
		stack.push(11);
		stack.push(43);
		
		
		stack.display();
		
		while(stack.size() >0){
			System.out.println("Pop--->"+ stack.pop() );
		}
		
		stack.display();
		
		//reversing a word
		
				
		
		
	}
	
}
