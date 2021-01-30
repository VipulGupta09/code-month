package slidingwindow;

//https://www.interviewbit.com/problems/sliding-window-maximum/#
/*Given an array of integers A. There is a sliding window of size B which
is moving from the very left of the array to the very right.
You can only see the w numbers in the window. Each time the sliding window moves
rightwards by one position. You have to find the maximum for each window.
The following example will give you more clarity.*/

/*Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7]*/

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem_IV {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		Problem_IV pr = new Problem_IV();
		// maxSlidingWindow(nums, k);

		Integer val = Integer.valueOf(10);
		System.out.println(val);

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {

		int i = 0, j = 0;
		int len = nums.length;
		int[] maxArray = new int[len - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int maxElement = Integer.MIN_VALUE;
		while (j < len) {
			queue.add(nums[j]);

			if (nums[j] > maxElement) {
				queue.removeAll(queue);
				queue.add(nums[j]);
				maxElement = nums[j];
			}
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				maxArray[i] = maxElement;
				if (nums[i] == maxElement) {
					queue.poll();
					if (!queue.isEmpty())
						maxElement = queue.peek();
					else
						maxElement = Integer.MIN_VALUE;
				}
				i++;
				j++;
			}
		}
		return maxArray;
	}
}
