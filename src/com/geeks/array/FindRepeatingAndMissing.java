package com.geeks.array;

public class FindRepeatingAndMissing {

	public static void main(String[] args) {
		int arr[] = {4, 3, 6, 2, 1, 1};
		findNum(arr);
	}
	
	public static void findNum(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			int abs_val = Math.abs(arr[i]);
			if(arr[abs_val-1]>0) {
				arr[abs_val-1]=-arr[abs_val-1];
			}
			else
				System.out.println("duplicate: "+abs_val);
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0)
				System.out.println("Missing: "+(i+1));
		}
		
	}

}
