package com.geeks.array;

import java.util.HashMap;

public class FindFirstRepeatingElement {

	public static void main(String[] args) {
		int arr[]={6, 10, 5, 4, 9, 120, 4, 6, 10};
		int arr1[]= {-1, 2, -1, 3, 2};
		findEle(arr);
	}
	public static void findEle(int[]arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int minIndex= Integer.MAX_VALUE;
		for(int i=arr.length-1;i>=0;i--) {
			if(map.containsKey(arr[i])) {
				if(i<minIndex)
					minIndex = i;
				map.put(arr[i], 1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		System.out.println(minIndex);
	}

}
