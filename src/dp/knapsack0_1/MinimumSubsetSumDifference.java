package dp.knapsack0_1;

import java.util.ArrayList;

// S1 = s1 & S2 = Range - s1 => Range -s1 -s1 = total => Range -2s1 will be minimum
public class MinimumSubsetSumDifference {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 2, 2, 1 }; // 1, 6, 11, 5
		int sum = calRange(arr);
		boolean[][] mat = subsetSum(arr, sum, arr.length);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = arr.length; i > arr.length - 1; i--) {
			for (int j = 0; j < (sum + 1) / 2; j++) {
				if (mat[i][j] == true)
					list.add(j);
			}
		}
		int minSum = Integer.MAX_VALUE;
		for (int j = sum / 2; j >= 0; j--) {
			if (mat[arr.length][j] == true) {
				int temp = sum - 2 * j;
				if (temp < minSum)
					minSum = temp;
			}
		}
		System.out.println(minSum);

		for (int i = 0; i < list.size(); i++) {
			int temp = sum - 2 * list.get(i);

			if (temp < minSum)
				minSum = temp;

		}
		System.out.println(minSum);

	}

	public static int calRange(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum;
	}

	public static boolean[][] subsetSum(int[] arr, int sum, int n) {
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

		return mat;
	}
}
