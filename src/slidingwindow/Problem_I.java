package slidingwindow;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1#
/*Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
*/
public class Problem_I {
	static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
		int i = 0;
		int j = 0;
		int sumMax = Integer.MIN_VALUE;
		int sumTillNow = 0;

		while (j < N) {
			sumTillNow += Arr.get(j);
			if ((j - i + 1) < K)
				j++;
			else if (j - i + 1 == K) {
				sumMax = Math.max(sumMax, sumTillNow);
				sumTillNow -= Arr.get(i);
				i++;
				j++;
			}
		}
		return sumMax;
	}

}
