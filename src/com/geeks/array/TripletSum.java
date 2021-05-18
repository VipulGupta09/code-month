package com.geeks.array;

import java.util.Arrays;

public class TripletSum {

	public static void main(String[] args) {
		int arr[] = { 12, 3, 4, 1, 6, 9 };
		int sum = 24;
		findTriplet(arr, sum);
	}

	// 1 3 4 6 9 12
	// 24
	// sum = 24 - (1+3+4)=16
	public static void findTriplet(int[] arr, int sum) {
		int i = 0, j = 1, k = 2;
		Arrays.sort(arr);
		sum -= arr[i] + arr[j] + arr[k];

		boolean kFlag = true, jFlag = true;
		while (sum > 0) {
			if (k < arr.length - 1 && kFlag) {
				sum += arr[k];
				k++;
				sum -= arr[k];
				if (sum < 0) {
					sum += arr[k];
					k--;
					sum -= arr[k];
					kFlag = false;
				}
			} else if (j < k - 1 && jFlag) {
				sum += arr[j];
				j++;
				sum -= arr[j];
				if (sum < 0) {
					sum += arr[j];
					j--;
					sum -= arr[j];
					jFlag = false;
				}
			} else {
				sum += arr[i];
				i++;
				sum -= arr[i];
			}
		}
		System.out.println(arr[k] + " " + arr[j] + " " + arr[i]);
	}

}
