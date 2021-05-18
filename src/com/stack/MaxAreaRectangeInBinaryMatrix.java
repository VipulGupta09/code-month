package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;



/*Here we will convert values of 2d matrix to 1d array 
and if there is 0 on the down side we will take this as zero 
rest we will add.
*/
class MAH1 {
	int val;
	int index;

	public MAH1(int val, int index) {
		this.val = val;
		this.index = index;
	}

	@Override
	public String toString() {
		return "MAH1 [val=" + val + ", index=" + index + "]";
	}

}

public class MaxAreaRectangeInBinaryMatrix {

	public static void main(String[] args) {
		
		  char arr[][] = {{'1','0','1','0','0'}, {'1','0','1','1','1'},
		  {'1','1','1','1','1'}, {'1','0','0','1','0'}};
		 
			/*
			 * char arr[][] = {{'1','1'}, {'1','1'}};
			 */
		int temp[] = new int[arr[0].length];
		for(int i=0;i<arr[0].length;i++) {
			temp[i]=arr[0][i]-'0';
		}
		int sum = AreaHistogram(temp);
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]-'0'==0)
					temp[j]=0;
				else
					temp[j]+=arr[i][j]-'0';
			}
			sum = Math.max(sum, AreaHistogram(temp));
		}
		System.out.println(sum);

	}

	public static int AreaHistogram(int arr[]) {
		//int arr[] = { 6, 2, 5, 4, 5, 1, 6 };

		List<Integer> left = findMinimumToLeft(arr);
		List<Integer> right = findMinimumToRight(arr);

		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int width = (right.get(i) - left.get(i) - 1);
			// System.out.print(width+' ');
			int height = arr[i];

			if (height * width > maxArea)
				maxArea = height * width;
		}

		//System.out.println(maxArea);

		return maxArea;

	}

	public static List<Integer> findMinimumToLeft(int[] arr) {
		Stack<MAH1> stack = new Stack<MAH1>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				list.add(-1);
			}

			else if (!stack.isEmpty() && stack.peek().val < arr[i]) {
				list.add(stack.peek().index);
			} else if (!stack.isEmpty() && stack.peek().val >= arr[i]) {
				while (!stack.isEmpty() && stack.peek().val >= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					list.add(-1);
				} else {
					list.add(stack.peek().index);
				}
			}
			stack.add(new MAH1(arr[i], i));
		}
		return list;
	}

	public static List<Integer> findMinimumToRight(int[] arr) {
		Stack<MAH1> stack = new Stack<MAH1>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (stack.isEmpty())
				list.add(arr.length);
			else if (!stack.isEmpty() && stack.peek().val < arr[i]) {
				list.add(stack.peek().index);
			} else if (!stack.isEmpty() && stack.peek().val >= arr[i]) {
				while (!stack.isEmpty() && stack.peek().val >= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					list.add(arr.length);
				} else {
					list.add(stack.peek().index);
				}
			}
			stack.add(new MAH1(arr[i], i));
		}
		Collections.reverse(list);
		return list;
	}
}
