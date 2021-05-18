package dp.knapsack0_1;

public class SubsetSum_DP {

	public static void main(String[] args) {

		int set[] = { 1,2,3,4 }, sum = 5;
		boolean val = knapSackTopDownCode(set, sum, set.length);
		System.out.println(val);
	}

	
	// wt = arr
	public static boolean knapSackTopDownCode(int[] arr, int sum, int n) {
		boolean mat[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					mat[i][j] = false;
				if (j == 0)
					mat[i][j] = true;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j) {
					mat[i][j] = mat[i - 1][j - arr[i - 1]] || mat[i - 1][j];
				} else {
					mat[i][j] = mat[i - 1][j];
				}
			}
		}

		return mat[n][sum];
	}
	/*
	 * //int set[] = { 1,2,3,4 }, sum = 5; 0 1 2 3 4 5 0[[true, false, false, false,
	 * false, false], 1[true, true, false, false, false, false], 2[true, true, true,
	 * true, false, false], 3[true, true, true, true, true, true], 4[true, true,
	 * true, true, true, true]]
	 */

}
