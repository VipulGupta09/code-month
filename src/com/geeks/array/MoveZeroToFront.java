package com.geeks.array;

import java.util.Arrays;

public class MoveZeroToFront {

	public static void main(String[] args) {
		int arr[]= {1, 10, 20, 0, 59, 63, 0, 88, 0};
		moveZero(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void moveZero(int arr[]) {
		int read_Index = arr.length-1;
		int write_Index = arr.length-1;
		
		while(read_Index>=0) {
			if(arr[read_Index]!=0) {
				arr[write_Index]=arr[read_Index];
				write_Index--;
			}
			read_Index--;
		}
		while(write_Index>=0) {
			arr[write_Index]=0;
			write_Index--;
		}
	}

}
