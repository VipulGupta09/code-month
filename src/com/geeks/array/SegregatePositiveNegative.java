package com.geeks.array;

import java.util.Arrays;

public class SegregatePositiveNegative {

	public static void main(String[] args) {
		int arr[] = { 2, 3, -4, -1, 6, -9 };
		rearrage(arr);
		System.out.println(Arrays.toString(arr));
		rearrangeAlt(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void rearrage(int[] arr) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (i != j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}

		}

	}
	
	public static void rearrangeAlt(int arr[]) {
		int i=0;
		for(i=0;i<arr.length;i++) {
			if(arr[i]>0)
				break;
		}
		int positiveIndex = i;
		int negativeIndex = 0;
		while(positiveIndex<arr.length && negativeIndex<arr.length) {
			int temp = arr[positiveIndex];
			arr[positiveIndex]=arr[negativeIndex];
			arr[negativeIndex]=temp;
			positiveIndex=positiveIndex+1;
			negativeIndex= negativeIndex+2;
		}
		
	}
}
