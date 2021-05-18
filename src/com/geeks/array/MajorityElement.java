package com.geeks.array;

public class MajorityElement {

	public static void main(String[] args) {
		int arr[]= {3, 3, 4, 2, 4, 4, 2, 4};
		findEle(arr);
	}
	public static void findEle(int arr[]) {
		int candidate = findCandidate(arr);
		
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==candidate) {
				count++;
			}
		}
		if(count> (arr.length/2))
			System.out.println(candidate);
		else
			System.out.println(-1);
	}
	
	public static int findCandidate(int arr[]) {
		int count = 1;
		int tempEle = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==tempEle) {
				count++;
			}
			else {
				count--;
			}
			if(count==0) {
				tempEle = arr[i];
				count=1;
			}
		}
		return tempEle;
	}
}
