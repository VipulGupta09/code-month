package com.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackUsingQueue {
	
	static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
	
	
	// 1 2 POP 3 4 POP 5
	// 3 5
	
	
	public static void push(int x) {
		if(q1.isEmpty())
			q1.add(x);
		else {
			add(q1,q2);
			remove(q1);
			q1.add(x);
			q1.addAll(q2);
			remove(q2);
		}
	}
	
	public static void remove(Queue<Integer> q) {
		while(!q.isEmpty())
			q.poll();
	}
	public static void add(Queue<Integer> q1,Queue<Integer> q2) {
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
	}
	public static void pop() {
		if(!q1.isEmpty()) {
			System.out.println(q1.poll());
		}
	}
	
	public static void print() {
		System.out.println(q1);
	}
	

	public static void main(String[] args) {
		
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("POP");
		list.add("3");
		list.add("4");
		list.add("POP");
		list.add("5");
		
		for(int i =0;i<list.size();i++) {
			String str = (String)list.get(i);
			switch (str) {
			case "POP": {
				pop();
				break;
			}
			
			default:
				push(Integer.parseInt(str));
			}
		}
		
		System.out.println(list);
		
		

	}

	
	
}
