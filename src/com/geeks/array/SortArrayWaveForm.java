package com.geeks.array;

import java.util.Arrays;

public class SortArrayWaveForm {

	public static void main(String[] args) {
		int arr[] = { 20, 10, 8, 6, 4, 2};
		sortWaveForm(arr);
	}

	public static void sortWaveForm(int arr[]) {
		for (int i = 0; i < arr.length; i = i + 2) {
			if (i > 0) {
				if (arr[i - 1] > arr[i]) {
					swap(i,i-1,arr);
				}
			}
			if(arr[i+1]>arr[i]) {
				swap(i,i+1,arr);
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int ele1, int ele2,int arr[]) {
		int temp = arr[ele1];
		arr[ele1] = arr[ele2];
		arr[ele2] = temp;
	}

}
