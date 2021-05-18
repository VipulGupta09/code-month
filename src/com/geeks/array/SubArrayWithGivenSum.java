package com.geeks.array;

import java.util.HashMap;

public class SubArrayWithGivenSum {
	
	
	public static void main(String[] args) {
		int arr[] = {-3, 2, 3, 1, 6}, sum = 0;
		findSubArrayWithSum(arr, sum);
	}

	public static void findSubArrayWithSum(int[]arr, int sum) {
		int tempSum= 0 ;
		int count = 0;
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			tempSum+=arr[i];
			if(tempSum==sum) {
				count++;
			}
				
			else if(map.containsKey(tempSum-sum)) {
				count++;
				map.put(tempSum-sum, map.get(tempSum-sum)+1);
				
			}
			else {
				map.put(tempSum, 1);
			}
		}
		System.out.println(count);
	}
}
