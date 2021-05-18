package com.geeks.array;

/*
 * https://www.geeksforgeeks.org/check-if-a-key-is-present-in-every-segment-of-size-k-in-an-array
 * */

public class CheckIfPresentInSegment {

	public static void main(String[] args) {
		int arr[]= {3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3};
		int x =3;
		int k = 3;
		find(arr,x,k);
	}
	public static void find(int[] arr, int num, int k) {
		int len = arr.length;
		for(int i=0;i<len;) {
			int size = (len-i)>=k?k:(len-i)	;
			int count =0;
			boolean flag = false;
			while(count<size) {
				if(arr[i]==num)
					flag = true;
				count++;
				i++;
			}
			if(!flag) {
				System.out.println(false);
				return;
			}
			if(i==len)
				break;
		}
		System.out.println(true);
	}

}
