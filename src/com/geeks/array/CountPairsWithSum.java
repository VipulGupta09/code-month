package com.geeks.array;

import java.util.HashMap;

public class CountPairsWithSum {

	public static void main(String[] args) {
		int arr[]={10, 12, 10, 15, -1, 7, 6, 
                5, 4, 2, 1, 1, 1};
		countPairs(arr,11);
	}
	public static void countPairs(int arr[],int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(sum-arr[i])) {
				count+=map.get(sum-arr[i]);
			}
			if(sum-arr[i]==arr[i])
				count--;
		}
		System.out.println(count/2);
	}

}
