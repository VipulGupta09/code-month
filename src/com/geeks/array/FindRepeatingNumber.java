package com.geeks.array;

public class FindRepeatingNumber {

	public static void main(String[] args) {
		int arr[]= {4, 2, 4, 5, 2, 3, 1};
		findRepeating(arr);
	}
	public static void findRepeating(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			if(arr[Math.abs(arr[i])]>0) {
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			}
			else {
				System.out.print(Math.abs(arr[i])+" ");
			}
		}
	}

}
