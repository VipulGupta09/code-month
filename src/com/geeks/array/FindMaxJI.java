package com.geeks.array;

public class FindMaxJI {
	
	/*Given an array arr[], find the maximum j � i such that arr[j] > arr[i]*/

	public static void main(String[] args) {
		 int arr[] = {  9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		 findValue(arr);
	}
	//9,   2, 3,  4,  5,  6,  7,  8,  18, 0
	//9,   2, 2,  2,  2,  2,  2,  2,  2,  0
	//18, 18, 18, 18, 18, 18, 18, 18, 18, 0
	public static void findValue(int arr[]) {
		int[] leftMin = new int[arr.length];
		int[] rightMax = new int[arr.length];
		
		leftMin[0]=arr[0];
		for(int i=1;i<arr.length;i++)
			leftMin[i]= Math.min(arr[i], leftMin[i-1]);
		
		rightMax[arr.length-1]=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--)
			rightMax[i]= Math.max(arr[i], rightMax[i+1]);
		
		int i = 0;
        int j = 0;
        int   maxDiff = -1;
        while (j < arr.length && i < arr.length) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }
        System.out.println(maxDiff);
		
	}
}
