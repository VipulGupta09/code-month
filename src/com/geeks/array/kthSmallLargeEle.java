package com.geeks.array;

import java.util.PriorityQueue;

public class kthSmallLargeEle {

	public static void main(String[] args) {
		int arr[]={7, 10, 4, 3, 20, 15} ;
		find(arr,3);
	}
	public static void find(int[]arr,int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i:arr)
			minHeap.add(i);
		while(k!=1) {
			minHeap.poll();
			k--;
		}
		System.out.println(minHeap.poll());
	}

}
