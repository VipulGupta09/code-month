package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;




class MAH{
	int val;
	int index;
	
	public MAH(int val,int index) {
		this.val = val;
		this.index = index;
	}

	@Override
	public String toString() {
		return "MAH [val=" + val + ", index=" + index + "]";
	}
	
}

public class MaximumAreaOfHistogram {

	public static void main(String[] args) {
		int arr[] = {6, 2, 5, 4, 5, 1, 6 };
		
		
	List<Integer> left = findMinimumToLeft(arr);
	List<Integer> right = findMinimumToRight(arr);
	
	
	int maxArea = 0;
	for(int i=0;i<arr.length;i++) {
		int width = (right.get(i) - left.get(i) -1);
		//System.out.print(width+" ");
		int height = arr[i];
		
		if(height * width>maxArea)
			maxArea = height * width;
	}
	
	System.out.println(maxArea);
	
	System.out.println(left);
	System.out.println(right);
	
	
	}
	//{5,5,1,7,1,1,5,2,7,6};
	public static List<Integer> findMinimumToLeft(int[]arr) {
		Stack<MAH> stack = new Stack<MAH>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<arr.length;i++) {
			if(stack.isEmpty()) {
				list.add(-1);
			}
				
			else if(!stack.isEmpty() && stack.peek().val<arr[i]) {
				list.add(stack.peek().index);
			}
			else if(!stack.isEmpty() && stack.peek().val>=arr[i]) {
				while(!stack.isEmpty() && stack.peek().val>=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(stack.peek().index);
				}
			}
			stack.add(new MAH(arr[i], i));	
		}
		return list;
	}

	public static List<Integer> findMinimumToRight(int[]arr) {
		Stack<MAH> stack = new Stack<MAH>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i =arr.length-1;i>=0;i--) {
			if(stack.isEmpty())
				list.add(arr.length);
			else if(!stack.isEmpty() && stack.peek().val<arr[i]) {
				list.add(stack.peek().index);
			}
			else if(!stack.isEmpty() && stack.peek().val>=arr[i]) {
				while(!stack.isEmpty() && stack.peek().val>=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(arr.length);
				}
				else {
					list.add(stack.peek().index);
				}
			}
			stack.add(new MAH(arr[i],i));	
		}
		Collections.reverse(list);
		return list;
	}
}
