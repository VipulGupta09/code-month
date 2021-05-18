package com.geeks.array;

public class MinimumNumOfJumps {

	public static void main(String[] args) {
	int	arr[] = {2,3,1,1,4};
	//	Output: 3 (1-> 3 -> 8 -> 9)
	System.out.println(findMinJumps(arr));
	}
	
	public static int findMinJumps(int arr[]) {
		if(arr.length<=1)
			return 0;
		int ladder = arr[0];
		int stairs = arr[0];
		
		int jump = 1;
		for(int level = 1;level<arr.length;level++) {
			/*
			 * if(level == arr.length-1) return jump;
			 */
			if(level+arr[level]>ladder)
				ladder = level+arr[level];
			stairs --;
			if(stairs == 0) {
				jump++;
				stairs = ladder-level;
			}
		}
		return jump;
	}

}
