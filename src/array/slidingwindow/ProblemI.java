package array.slidingwindow;

import java.util.ArrayList;

/*Given an array of integers of size ‘n’.
Our aim is to calculate the maximum sum of ‘k’ 
consecutive elements in the array.*/
public class ProblemI {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		int maxSum = find(arr, k);
		System.out.println(maxSum);
	}

	public static int find(int arr[], int k) {
		int start =0, end =0; // keep trace of start and end of window
		if (arr.length < k)
			return -1;
		int windowSum = 0;
		int maxSum = 0;
		for (int i = 0; i < k; i++)
			maxSum += arr[i];

		windowSum = maxSum;
		for (int i = k; i < arr.length; i++) {
			windowSum -= arr[i - k]; // deleting the start index element
			windowSum += arr[i]; // adding the current index element

			if (windowSum > maxSum) {
				maxSum = windowSum;
				start=i-k+1;
				end =i+1;
			}

		}
		for(int i=start;i<end;i++)
			System.out.print(arr[i]+" ");
		return maxSum;
	}
}
