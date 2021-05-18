package com.recursion;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		// System.out.println(print(5));
	//	System.out.println(printFactorial(6, 1));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(4);
		list.add(55);
		list.add(1);
		list.add(-1);
		list.add(5);
		list.add(13);
		list.add(2);
		//sortArrray(list);
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(-3);
		stack.add(14);
		stack.add(18);
		stack.add(-5);
		stack.add(30);
		stack.add(0);
	//	sortStack(stack);
		System.out.println(stack);
		//deleteMiddleOfStack(stack, 3);
		//reverseStack1(stack);
		System.out.println(stack);
		String str  = "";
	//	openCloseBracker(3, 3, str, new ArrayList<String>());
		toi(3, 1, 3, 2);
	}

	public static int print(int n) {
		if (n == 0) {
			// System.out.println(n);
			return 1;
		}
		int val = print(n - 1);
		return (n * val);

	}

	// 5
	public static int printFactorial(int n, int fact) {
		if (n == 1)
			return fact;

		fact = fact * n;
		return printFactorial(n - 1, fact);
	}
	
	// 10 4 55 1 -1 5 13 2
	public static void sortArrray(ArrayList<Integer> arr) {
		if(arr.size() == 1)
			return ;
		int temp = arr.remove(arr.size()-1);
		
		 sortArrray(arr);
		insert(arr,temp);
	}
	public static void insert(ArrayList<Integer>arr, int temp) {
		if(arr.size() == 0 || arr.get(arr.size()-1)<=temp) {
			arr.add(temp);
			return;
		}
		int val = arr.remove(arr.size()-1);
		insert(arr, temp);
		arr.add(val);
	}
	
	
	public static void sortStack(Stack<Integer> stack) {
		if(stack.size()==1) {
			return;
		}
		int val = stack.pop();
		sortStack(stack);
		insertIntoStack(stack,val);
	}
	public static void insertIntoStack(Stack<Integer> stack, int val) {
		if(stack.size()==0 || stack.peek()>=val) {
			stack.add(val);
			return;
		}
		
		int temp = stack.pop();
		insertIntoStack(stack, val);
		stack.add(temp);
		
	}
	
	public static Stack<Integer> deleteMiddleOfStack(Stack<Integer> stack,int k) {
		if(stack==null)
			return null;
		solve(stack,k);
		return stack;
	}
	public static void solve(Stack<Integer> stack, int k) {
		if(k==1) {
			stack.pop();
			return;
		}
		int temp = stack.pop();
		solve(stack,k-1);
		stack.add(temp);
	}
	
	public static void reverseStack1(Stack<Integer> stack) {
		if(stack.size()==1)
			return;
		int temp = stack.pop();
		reverseStack1(stack);
		reverseStack(stack,temp);
	}
	
	public static void reverseStack(Stack<Integer> stack,int temp) {
		if(stack.size()==0) {
			stack.add(temp);
			String str;
			char ch = '1';
			int i = ch - 'a';
			return;
		}
			
		int val = stack.pop();
		reverseStack(stack,temp);
		stack.add(val);
		
	}
	
	
	public static ArrayList<String> openCloseBracker(int open, int close, String str, ArrayList<String> output) {
		if(open == 0 && close ==0 ) {
			output.add(str);
			return output;
		}
	String op1;
	String op2;
	
	if(open!=0) {
		op1 = str;
		str+="(";
		openCloseBracker(open-1, close, str, output);
	}
	if(close>open) {
		op2 = str;
		str+=")";
		openCloseBracker(open, close-1, str, output);
	}
	return output;
			
	}
	static long count;
	
	public static long toi(int n, int source, int dest, int helper) {
		count++;
		
		if(n == 1) {
			System.out.println("Move "+ n +" plate from tower " + source +" to "+ dest);
			return count;
		}
		
		toi(n-1, source, helper, dest);
		System.out.println("Move "+ n +" plate from tower " + source +" to "+ dest);
		toi(n-1, helper, dest, source);
		
		return count;
		
	}

}
