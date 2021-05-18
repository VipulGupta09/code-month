package dp.knapsack0_1;

public class Knapsack {
	static int[][] dp = new int[1000][1000];

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		int maxWeight = knapsack(val, wt, W, n);
		System.out.println(maxWeight);

		for (int i = 0; i < dp.length; i++)
			for (int j = 0; j < dp[i].length; j++)
				dp[i][j] = -1;

		int maxWeightMemoize = knapsackMemoizeCode(val, wt, W, n);
		System.out.println(maxWeightMemoize);
		
		int maxWeightTopDown = knapSackTopDownCode(val, wt, W, n);
		System.out.println(maxWeightTopDown);
		
	}

	public static int knapsack(int[] val, int[] wt, int W, int n) {
		// Base Condition
		if (W == 0 || n == 0)
			return 0;

		else if (wt[n - 1] <= W) {
			return Math.max(val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1), knapsack(val, wt, W, n - 1));
		} else {
			return knapsack(val, wt, W, n - 1);
		}
	}

	public static int knapsackMemoizeCode(int[] val, int[] wt, int W, int n) {
		// Base Condition
		if (W == 0 || n == 0)
			return 0;

		if (dp[n][W] != -1)
			return dp[n][W];

		else if (wt[n - 1] <= W) {
			return dp[n][W] = Math.max(val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1),
					knapsack(val, wt, W, n - 1));
		} else {
			return dp[n][W] = knapsack(val, wt, W, n - 1);
		}
	}
	
	// i==n,W==j
	public static int knapSackTopDownCode(int[] val, int[] wt, int W, int n) {
		int mat[][] = new int [n+1][W+1];
		
		/*
		 * for(int i=0;i<n+1;i++) { for(int j=0;j<W+1;j++) { if(i==0 || j==0)
		 * mat[i][j]=0; } }
		 */
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(i==0 || j ==0)
					mat[i][j] =0;
				
				else if(wt[i-1]<=j) {
					mat[i][j] = Math.max(val[i-1]+ mat[i-1][j-wt[i-1]], 
									mat[i-1][j]);
				}
				else {
					mat[i][j] = mat[i-1][j];
				}
			}
		}
		
		return mat[n][W];
	}

}
