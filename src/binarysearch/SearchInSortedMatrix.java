package binarysearch;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int mat[][] =	  { {10, 20, 30, 40},
							{15, 25, 35, 45},
							{27, 29, 37, 48},
							{32, 33, 39, 50}};
       int  x = 29;
       System.out.println(search(mat, x));
	}
	
	public static String search(int mat[][], int key) {
		int i=0, j = mat[0].length-1;
		while(i<mat.length && j>=0) {
			if(mat[i][j] == key) {
				return i+" "+j;
			}
			else if(mat[i][j]>key) {
				j--;
			}
			else {
				i++;
			}	
		}
		return "-1";
	}

}
