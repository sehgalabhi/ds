package com.ds.trees;

public class TreeTest {

	public static void main(String[] args) {
		
		Tree tree = new Tree();
		tree.insert(5);
		
		tree.insert(2);
		
		tree.insert(7);
		
		
		
		tree.insert(4);
		
		System.out.println("Inorder");
		tree.inorderDisplay();
		System.out.println("preorder");
		tree.preOrderTraversal();
		System.out.println("Postorder");
		tree.postOrderTraversal();
		
		//tree.displayTree();
		System.out.println("Found" + tree.find(4));
		System.out.println("Found" + tree.find(3));
		
//		tree.delete(4);
		
		
	}
	
}
