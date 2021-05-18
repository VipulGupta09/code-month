package com.geeks.array;

public class MaximumProduct {
	
/**
 1. If arr[i] is positive then multiply with max and min = Math.min(min,arr[i])
 2. If arr[i] is zero then reset all digit to 1;
 3. If arr[i] is negative then swap min and max also min = arr[i]*min and max = Math.max(1, arr[i]*max)
 */

	public static void main(String[] args) {
		int arr[] = {0,0,0,3,-2,-9};
		findMaxSum(arr);
	}
	public static void findMaxSum(int[]arr) {
		int result = 1;
		int max = 1;
		int min = 1;
	
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				max*=arr[i];
				min = Math.min(min, arr[i]);
			}
			else if(arr[i]==0) {
				max = 1;
				min = 1;
			}
			else {
				int temp = max;
				 max = min;
				 min = temp;
				 
				 min = arr[i]*min;
				 max = Math.max(1, arr[i]*max);
			}
			result = Math.max(result , max);
		}
		System.out.println(result);
	}

}
