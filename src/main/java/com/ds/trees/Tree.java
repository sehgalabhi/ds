package com.ds.trees;

public class Tree {

	public Node root;

	public Tree() {

	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);

		Node current = root;
		Node previous = root;

		while (true) {
			if (current != null) {
				previous = current;
				if (data < current.data) {
					current = current.leftChild;
					if (current == null) {
						previous.leftChild = newNode;
						return;
					}

				} else {
					current = current.rightChild;
					if (current == null) {
						previous.rightChild = newNode;
						return;
					}
				}
			} else {
				current = newNode;
				if (isEmpty()) {
					root = current;
				}
				break;
			}
		}

	}

	public int find(int key) {
		Node current = root;

		while (true) {
			if (current != null) {
				if (key == current.data) {
					return key;
				} else if (key < current.data) {
					current = current.leftChild;

				} else {
					current = current.rightChild;

				}
			} else {
				return -1;

			}
		}
	}

	public int delete(int key) {
		Node current = root;
		Node previous = root;
		boolean isLeftChild = false;

		while (true) {
			if (current != null) {

				if (key == current.data) {
					break;
				}

				else {
					previous = current;
					if (key < current.data) {

						current = current.leftChild;
						isLeftChild = true;

					} else {
						current = current.rightChild;
						isLeftChild = false;

					}
				}
			} else {
				return -1;

			}
		}
		
		// no child
		if(current.leftChild == null && current.rightChild == null){
			if(current  == root){
				root = null;
			}
			if(isLeftChild){
				previous.leftChild = null;
			} else{
				previous.rightChild =null;
			}
		} 
		// no right child
		else if (current.rightChild == null){
			if(current == root) {
				root = current.leftChild;				
			} else if(isLeftChild){
				previous.leftChild = current.leftChild;
			} else{
				previous.rightChild = current.leftChild;
			}
		}
		
		// no left child
		else if (current.leftChild == null){
			if(current == root) {
				root = current.rightChild;				
			} else if(isLeftChild){
				previous.leftChild = current.rightChild;
			} else{
				previous.rightChild = current.rightChild;
			}
		}  
		
		// both child are present
		else{
			Node successor  = getSuccessor(current);
			
			
			 
			}
			
		return -1;

	}
	
	private Node getSuccessor(Node delNode){
		Node previous = delNode;
		Node successor = delNode;
		
		Node current = delNode.rightChild;
		
		while (current != null){
			previous = current;
			current = current.leftChild;
		}
		
		return null;
	}

	public void inorderDisplay() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.leftChild);
		root.displayNode();
		inorderTraversal(root.rightChild);

	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		postOrderTraversal(root.leftChild);
		postOrderTraversal(root.rightChild);
		root.displayNode();
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		root.displayNode();
		preOrderTraversal(root.leftChild);
		preOrderTraversal(root.rightChild);

	}
}
