package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindClosestNumbers {
	public static void main(String[] args) {
		int arr[] = {-10, -50, 20, 17, 80}, x = 20, k = 2;
		
		find(arr, x, k);
	}
	public static void find(int arr[], int x, int k) {
		
		PriorityQueue<Pair>  maxHeap = new PriorityQueue<Pair>(Collections.reverseOrder());
		
		
		for(int i=0;i<arr.length;i++) {
			maxHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
			if(maxHeap.size()>k)
				maxHeap.poll();
		}
		while(!maxHeap.isEmpty())
			System.out.print(maxHeap.poll().getVal()+" ");
	}
}

class Pair implements Comparable<Pair>{
	int absVal;
	int val;	
	
	public Pair(int absVal,int val) {
		this.absVal = absVal;
		this.val = val;
	}

	public int getAbsVal() {
		return absVal;
	}

	public int getVal() {
		return val;
	}

	
	@Override
	public String toString() {
		return "Pair [absVal=" + absVal + ", val=" + val + "]";
	}

	@Override
	public int compareTo(Pair o) {
		return absVal-o.absVal;
	}
	
}
