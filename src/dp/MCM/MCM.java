package dp.MCM;

public class MCM {
	static int[][] mat = new int[101][101]; // arr.size +1
	public static void main(String[] args) {
		int arr[]={40, 20, 30, 10, 30} ;
		
		// for memoized version
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				mat[i][j]=-1;
			}
		}
		
		int minValue = solve(arr, 1, arr.length-1);
		System.out.println(minValue);
	}
	//
	public static int solve(int arr[], int i , int j) {
		
		if(i>=j) {
			return 0;
		}
		
		int mm = Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int tempAns = solve(arr, i, k)+ solve(arr, k+1, j)
								+(arr[i-1] * arr[k]* arr[j]); // This is for(A.B.C.D) AB * CD  manually
			if(tempAns<mm)
				mm = tempAns;
		}
		
		return mm;
	}
	public static int solveMemoized(int arr[], int i , int j) {
		
		if(i>=j) {
			return 0;
		}
		if(mat[i][j]!=-1)
			return mat[i][j];
		int mm = Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int tempAns = solve(arr, i, k)+ solve(arr, k+1, j)+(arr[i-1] * arr[k]* arr[j]);
			if(tempAns<mm)
				mm = tempAns;
		}
		mat[i][j]=mm;
		return mm;
	}

}
