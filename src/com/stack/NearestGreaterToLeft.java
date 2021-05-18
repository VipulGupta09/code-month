package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {
	public static void main(String[] args) {
		 int arr[] = { 4,5,2,10,8 };
		 
		// findGreaterToLeft(arr);
		// findGreaterToRight(arr);
		// findSmallestToRight(arr);
		 findSmallestToLeft(arr);
	}
	
	public static void findSmallestToRight(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = arr.length-1;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int j=len ;j>=0;j--) {
			
			if(stack.isEmpty()) {
				list.add(-1);
			}
			else if(!stack.isEmpty() && stack.peek()<arr[j]) {
				list.add(stack.peek());
			}
			else if(!stack.isEmpty() && stack.peek()>=arr[j]) {
				
				while(!stack.isEmpty() && stack.peek()>arr[j]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(stack.peek());
				}
				
			}
			stack.add(arr[j]);
		}
		Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void findSmallestToLeft(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = arr.length-1;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int j=0 ;j<=len;j++) {
			
			if(stack.isEmpty()) {
				list.add(-1);
			}
			else if(!stack.isEmpty() && stack.peek()<arr[j]) {
				list.add(stack.peek());
			}
			else if(!stack.isEmpty() && stack.peek()>=arr[j]) {
				
				while(!stack.isEmpty() && stack.peek()>arr[j]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(stack.peek());
				}
				
			}
			stack.add(arr[j]);
		}
		//Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void findGreaterToRight(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = arr.length-1;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int j=len ;j>=0;j--) {
			
			if(stack.isEmpty()) {
				list.add(-1);
			}
			else if(!stack.isEmpty() && stack.peek()>arr[j]) {
				list.add(stack.peek());
			}
			else if(!stack.isEmpty() && stack.peek()<=arr[j]) {
				
				while(!stack.isEmpty() && stack.peek()<arr[j]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(stack.peek());
				}
				
			}
			stack.add(arr[j]);
		}
		Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void findGreaterToLeft(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = arr.length-1;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int j=0 ;j<=len;j++) {
			
			if(stack.isEmpty()) {
				list.add(-1);
			}
			else if(!stack.isEmpty() && stack.peek()>arr[j]) {
				list.add(stack.peek());
			}
			else if(!stack.isEmpty() && stack.peek()<=arr[j]) {
				
				while(!stack.isEmpty() && stack.peek()<arr[j]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(stack.peek());
				}
				
			}
			stack.add(arr[j]);
		}
		//Collections.reverse(list);
		System.out.println(list);
	}
}
