package com.geeks.array;

public class ReverseArray {

	public static void main(String[] args) {
		int arr[]={4, 5,7,1, 2};
		reverse(arr);
	}
	public static void reverse(int[] arr) {
		int start = 0,  end = arr.length-1;
		while(start<=end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}

}
