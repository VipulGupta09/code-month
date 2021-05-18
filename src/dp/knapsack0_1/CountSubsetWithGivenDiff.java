package dp.knapsack0_1;

public class CountSubsetWithGivenDiff {

	//Sum(s1) - Sum(s2) = diff
	//Sum(s1) + Sum(s2) = Sum(arr)
	// 2Sum(s1) =  diff + Sum(arr)
	// Sum(s1) = [diff + Sum(arr)]/2
	// Now apply Count the subsets with given sum with sum = [diff + Sum(arr)]/2
	public static void main(String[] args) {
		int arr[] = {1};
		int diff = 2;
		
		int sum1 = (calRange(arr)+diff)/2;
		int count = subsetSum(arr, sum1, arr.length);
		System.out.println(count);

	}
	public static int calRange(int arr[]) {
		int sum = 0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		return sum;
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
