package com.geeks.array;

public class Maximum1inrow {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 1, 1 },
						{ 0, 0, 1, 1 }, 
						{ 0, 1, 1, 1 }, // this row has maximum 1s
						{ 1, 1, 1, 1 } };
		int index = 0;
		int rowNum = 0;
		index = check(mat,0,mat[0].length-1);
		for (int row = 1; row < mat[0].length; row++) {
				if(mat[row][mat.length-index]==1) {
					index = check(mat,row,mat.length-index);
					rowNum = row;
				}
					
		}
		System.out.println(rowNum);

	}

	public static int check(int mat[][], int row,int count) {
		int index = 0;
		for (int i = count; i >= 0; i--) {
			if (mat[row][i] != 1)
				break;
			index++;
		}
		return index;
	}

}
