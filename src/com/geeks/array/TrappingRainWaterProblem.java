package com.geeks.array;

public class TrappingRainWaterProblem {

	public static void main(String[] args) {
		int arr[]= {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		findWater(arr);	
	}
//3, 0, 2, 0, 4
//3, 3, 3, 3, 4
//4	,4,	4 , 4, 4
//0, 3, 1,  3, 
//0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3
//2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1
	public static void findWater(int arr[]) {
		int[] leftMax = leftMax(arr);
		int[] rightMax= rightMax(arr);
		
		int waterStore = 0;
		
		for(int i=0;i<arr.length;i++) {
			int min = Math.min(leftMax[i], rightMax[i]);

			waterStore+=min-arr[i];
		}
		System.out.println(waterStore);
		
	}
	
	public static int[] leftMax(int arr[]) {
		int leftMax[]=new int[arr.length];
		leftMax[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(leftMax[i-1]>=arr[i])
				leftMax[i]=leftMax[i-1];
			else
				leftMax[i]=arr[i];
		}
		return leftMax;
	}
	
	public static int[] rightMax(int arr[]) {
		int len = arr.length;
		int rightMax[]=new int[len];
		
		rightMax[len-1]=arr[len-1];
		for(int i=len-2;i>=0;i--) {
			if(rightMax[i+1]>=arr[i])
				rightMax[i]=rightMax[i+1];
			else
				rightMax[i]=arr[i];
		}
		return rightMax;
	}

}
