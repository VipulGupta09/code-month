package com.geeks.array;

import java.util.Arrays;

// Assume we have 3 regions o to low-1 & low to mid-1 & mid to high-1 (unknown)& high to last
// for every 0 shrink the unknown region and same for 1

public class Segregate012 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		segregate(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void segregate(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (mid <= high) {
			switch (arr[mid]) {
			case 0: {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
				break;
			}
			case 1: {
				mid++;
				break;
			}
			case 2: {
				int temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
				break;
			}
			}
		}
	}
}
