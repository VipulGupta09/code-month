package com.geeks.array;

import java.util.HashMap;
import java.util.Map;

public class CommonInTreeSortedArray {

	public static void main(String[] args) {
		int arr1[] = { 1, 5, 5 };
		int arr2[] = { 3, 4, 5, 5, 10 };
		int arr3[] = { 5, 5, 10, 20 };

		findCommon(arr1, arr2, arr3);
	}

	public static void findCommon(int[] arr1, int[] arr2, int[] arr3) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		addToMap(map, arr1, 1);
		addToMap(map, arr2, 2);
		addToMap(map, arr3, 3);
		
		for(Map.Entry<Integer, Integer> m:map.entrySet()) {
			if(m.getValue()==3)
				System.out.println(m.getKey()+" ");
		}
		
	}
	public static void addToMap(HashMap<Integer, Integer> map, int arr[],int count) {
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int temp = map.get(arr[i]);
				if(temp<count)
				map.put(arr[i], temp+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
	}
}
