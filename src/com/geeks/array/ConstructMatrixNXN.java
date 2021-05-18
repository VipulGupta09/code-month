package com.geeks.array;

import java.util.Arrays;

public class ConstructMatrixNXN {
//first place the 1 at their place, then alternative rows
// put count 1-5 at their p
	public static void main(String[] args) {
		int num = 10;
		constructMatrix(num);
		
	}
/*  _ _ _ _ 1 
	1 _ _ _ _ 
	_ _ _ 1 _ 
	_ 1 _ _ _ 
	_ _ 1 _ _ */
	
/*	[[5, 3, 2, 4, 1],
	 [1, 4, 3, 5, 2],
	 [2, 5, 4, 1, 3],
	 [3, 1, 5, 2, 4],
	 [4, 2, 1, 3, 5]]*/
	public static void constructMatrix(int num) {
		int matrix[][]= new int [num][num];
		
		int right = num-1;
		int left = 0;
		
		for(int i=0;i<num;i++) {
			if(i%2==0) {
				matrix[i][right]=1;
				fillElement(i,right,matrix);
				right--;
				
			}
			else {
				matrix[i][left]=1;
				fillElement(i,left,matrix);
				left++;
				
			}
		}
		for(int[] row : matrix) {
			
			System.out.println(Arrays.toString(row));
		}
		
	}
	
	public static void fillElement(int row, int col,int mat[][]) {
		int count = 1;
		while(count!=mat[0].length) {
			int rowTemp = (row+1)%mat[0].length;
			mat[rowTemp][col]=++count;
			row++;
		}
		
	}
}
