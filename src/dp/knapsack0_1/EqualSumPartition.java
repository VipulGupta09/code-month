package dp.knapsack0_1;

public class EqualSumPartition {

	public static void main(String[] args) {
		int arr[] = {1, 5, 3};
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		
		if(sum%2!=0)
			System.out.println(false);
		else
			System.out.println(subsetSum(arr, sum/2, arr.length));

	}

	public static int knapsack(int val[], int wt[], int W, int n) {
		if (W == 0 || n == 0)
			return 0;
		else if (wt[n - 1] <= W) {
			return Math.max(val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1), knapsack(val, wt, W, n - 1));
		}
		return knapsack(val, wt, W, n - 1);
	}

	// n=i,W=j
	public static int knapsackTopDown(int val[], int wt[], int W, int n) {

		int dp[][] = new int[n + 1][W + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < W + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return -1;
	}

	//arr, sum, n
	// wt, 
	public static boolean subsetSum(int arr[], int sum, int n) {

		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i < sum + 1; i++) {
			dp[0][i] = false;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]]|| dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

}
