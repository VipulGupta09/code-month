package com.geeks.array;

public class PairSumClosestToX {

	public static void main(String[] args) {
	int	arr[] = {1, 3, 4, 7, 10}, x = 15;
	findCloseset(arr, x, arr.length);
	}
	public static void findCloseset(int arr[], int x, int len) {
		int start = 0;
		int end = len -1;
		int diff = Integer.MAX_VALUE;
		
		int p1 = 0, p2 =0;
		while(start<end) {
			if(Math.abs(arr[start]+arr[end]-x) < diff) {
				p1 = arr[start];
				p2 = arr[end];
				diff = Math.abs(arr[start]+arr[end]-x);
			}
			else if(arr[start]+arr[end]>x)
				end--;
			else
				start++;
		}
		System.out.println(p1+" "+p2);
	}
}
