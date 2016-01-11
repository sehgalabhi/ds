package com.ds;

public class ArrayList {
	int size = 0;

	double[] a;

	public ArrayList(int capacity) {
		a = new double[capacity];
	}

	public void insert(double val) {
		a[size] = val;
		size++;
	}

	public boolean find(double val) {
		boolean pres = false;
		for (int i = 0; i < size; i++) {
			if (a[i] == val) {
				pres = true;
				break;
			}
		}

		return pres;

	}

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

	public void selectionSort(){
	  //start with leftmost position, continue comparing for the smallest number
		//swap the numbers
		//report this moving from left to right
		
		for (int left = 0; left < size -1; left++) {
			double minValue = a[left];
			int minPosition = left;
			for (int j = left; j < size ;j ++) {			
				if(a[j] < minValue){
					minPosition = j;
					minValue = a[j];
				}
				
			}
			swap(left, minPosition);
			
		}
		
		
	}
	
	
	public void insertionSort(){
		// start outer from second position till end
		// copy inner to temp
		//compare inner with left places elements, move them right if they are higher than
		//temp
		//place the inner at a position where temp is higher than left
		
		
		int outer, in ;
		double tempValue;
		for ( outer = 0; outer < size; outer++) {
			tempValue = a[outer];
			
			for (in = outer -1; in >= 0; in--) {
				
				if(tempValue < a[in]){
					a[in+1] = a[in];
				} else{
					a[in+1] = tempValue;
					break;
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
