package com.ordenacion;

public class Aaaa {

	public static void main(String[] args) {
		int[] numArray = {2, 2, 4, 6, 7, 3, 3, 8, 9, 6};
		// TODO Auto-generated method stub
	    int n = numArray.length;
	    int temp = 0;

	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {
	            if (numArray[j - 1] > numArray[j]) {
	                temp = numArray[j - 1];
	                numArray[j - 1] = numArray[j];
	                numArray[j] = temp;
	            }
	        }
	    }
	    
	    for ( int a : numArray) {
	    	System.out.println(a);
	    }
	    
	}
}
