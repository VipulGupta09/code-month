package com.stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		int[] maxLeft = findMaxLeft(heights);
		int[] maxRight = findMaxRight(heights);
		
		int totalWater = 0;
		for(int i=0;i<heights.length;i++) {
			totalWater+= Math.min(maxLeft[i], maxRight[i])-heights[i];
		}
		System.out.println(totalWater);

	}
	
	public static int[] findMaxLeft(int arr[]) {
		int [] maxLeft = new int[arr.length];
		maxLeft[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>maxLeft[i-1])
				maxLeft[i]=arr[i];
			else
				maxLeft[i] = maxLeft[i-1];
		}
		
		  for(int i : maxLeft) System.out.print(i+" ");
		 
		System.out.println();
		return maxLeft;
	}
	
	public static int[] findMaxRight(int arr[]) {
		int len = arr.length-1;
		int [] maxRight = new int[arr.length];
		maxRight[len] = arr[len];
		for(int i=len-1;i>=0;i--) {
			if(arr[i]>maxRight[i+1])
				maxRight[i]=arr[i];
			else
				maxRight[i] = maxRight[i+1];
		}
		
		  for(int i : maxRight) System.out.print(i+" ");
		 
		return maxRight;
	}

}
