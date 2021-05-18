package com.geeks.array;

import java.util.Arrays;

public class MinimiseTheMaximumDifferenceBetweenHeights {

	public static void main(String[] args) {
		int arr[]={1, 5, 15, 10};
		int k = 3;
		System.out.println(findDiff(arr, k));
	}
	
// max: 4, 8, 18, 13
// min:-2, 2, 12, 7
	public static int findDiff(int arr[], int k) {
		int n = arr.length;
		Arrays.sort(arr);
		int ans = arr[n-1]-arr[0];
		
		for(int i=0;i<arr.length-1;i++) {
			int a = arr[i], b = arr[i+1];
			
			int high = Math.max(arr[n-1]-k, a+k);
			int low = Math.min(arr[0]+k, b-k);
			ans = Math.min(ans,high-low);
			
		}
		
		return ans;
	}

}
