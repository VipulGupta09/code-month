package dp.knapsack0_1;

public class CountOfSubsetWithGivenSum {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 3}, X = 6;
		int arr2[]= {1, 2},X2=8;
		int count = subsetSum(arr2, X2, arr2.length);
		System.out.println(count);

	}
	public static int subsetSum(int arr[], int sum, int n) {

		int dp[][] = new int[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < sum + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]]+ dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
