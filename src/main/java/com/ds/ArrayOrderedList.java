package com.ds;

public class ArrayOrderedList {
	int size = 0;

	double[] a;

	public ArrayOrderedList(int capacity) {
		a = new double[capacity];
	}

	//assuming linear search for insert
	public void insert(double val) {
		for (int i = 0; i <= size; i++) {
			if(a[i]  > val){
				
				for (int j = size; j >=i; j--) {
					a[j+1]=a[j];
					
				}
				a[i]=val;
				break;
			} else{
				a[size]=val;
			}
		}
		size++;
	}

	//binary search
	public boolean find(double val) {
		boolean pres = false;
		int upper =size-1;
		int lower = 0;
		int mid;
		
		while(true){
			mid = (lower+upper)/2;
			
			
			if(a[mid] == val){
				pres = true;
				break;
			} else{
				if(upper<lower){
					break;
				}
				if(a[mid] < val){
					lower = mid+1;
				} else{
					upper = lower -1;
				}
				
			}
			
		}
		
		for (int i = 0; i < size; i++) {
			if (a[i] == val) {
				pres = true;
				break;
			}
		}

		return pres;

	}

	//assuming linear search for delete
	public void delete(double val) {
		boolean pres = false;
		for (int i = 0; i < size; i++) {
			if (a[i] == val) {
				pres = true;
				for (int j = i; j < size; j++) {
					a[j] = a[j + 1];
				}
				size--;
				break;
			}
		}

	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public int size() {
		return size;
	}

	public void bubbleSort() {
		// start from left compare left and left+1, swap if required
		// continue till N-1
		// iterate above with decreasing N

		for (int right = size; right > 1; right--) {

			for (int left = 0; left < right - 1; left++) {

				if (a[left] > a[left + 1]) {
					swap(left, (left + 1));
				}

			}
		}
	}

	private void swap(int t, int b) {
		double temp = a[t];
		a[t] = a[b];
		a[b] = temp;
	}

}
