package com.geeks.array;

public class MaximumSumPathInTwoArray {

	public static void main(String[] args) {
		int arr1[] = { 10, 12 };
		int arr2[] = { 5, 7, 9 };
		findMax(arr1, arr2);
	}

	public static void findMax(int arr1[], int arr2[]) {
		int sum1 = 0;
		int sum2 = 0;
		int result = 0;
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				sum1 += arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				sum2 += arr2[j];
				j++;
			} else {
				result += Math.max(sum2, sum1);
				sum1 = sum2 = 0;

				while (arr1[i] == arr2[j] && i < arr1.length && j < arr2.length) {
					result += arr1[i];
					i++;
					j++;
				}
			}

		}
		while (i < arr1.length) {
			sum1 += arr1[i];
			i++;
		}
		while (j < arr2.length) {
			sum2 += arr2[j];
			j++;
		}
		result += Math.max(sum1, sum2);
		System.out.println(result);
	}
}
