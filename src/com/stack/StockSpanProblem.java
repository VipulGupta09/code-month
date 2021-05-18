package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		int price[] = { 100, 80, 60, 70, 60, 75,85 };
		// 1 1 2 4 5 1
		findGreatestFromLeft(price);
	}

	public static void findGreatestFromLeft(int arr[]) {

		Stack<Stock> stack = new Stack<Stock>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (stack.isEmpty()) {
				list.add(1);
			} else if (!stack.isEmpty() && stack.peek().val > arr[i]) {
				list.add(i - stack.peek().index );
			} else if (!stack.isEmpty() && stack.peek().val < arr[i]) {
				while (!stack.isEmpty() && stack.peek().val < arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty())
					list.add(i+1);
				else
					list.add(i - stack.peek().index );
			}
			stack.add(new Stock(arr[i],i));
		}
		System.out.println(list);
	}

}

class Stock{
	int val;
	int index;
	public Stock(int val,int index) {
		this.val = val;
		this.index = index;
	}
}
