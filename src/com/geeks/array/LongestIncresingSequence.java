package com.geeks.array;

public class LongestIncresingSequence {

	public static void main(String[] args) {
		int arr[]= {10, 22, 9, 33, 21, 50, 41, 60, 80};
		find(arr);
	}
	public static void find(int arr[]) {
		int maxVal = Integer.MIN_VALUE;
		int[] list  = new int[arr.length];
		list[0]=1;
		for(int i=1;i<arr.length;i++) {
			list[i]=1;
			
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && list[i]<=list[j])
					list[i]=1+list[j];
					if(list[i]>maxVal)
						maxVal = list[i];
			}
			
		}
		System.out.println(maxVal);
	}

}
