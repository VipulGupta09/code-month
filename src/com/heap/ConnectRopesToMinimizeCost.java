package com.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ConnectRopesToMinimizeCost {

	public static void main(String[] args) {
		long arr[] = { 4, 2, 7, 6, 9};
		int n = 4;
		minCost(arr, n);
	}

	public static void minCost(long arr[], int n) {
		PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
		for(long i : arr) {
			minHeap.add(i);
		}
		long cost =0;
		while(minHeap.size()>=2) {
			long first = minHeap.poll();
			long second = minHeap.poll();
			long temp =first + second;
			cost += temp;
			minHeap.add(temp);
		}
		System.out.println(cost);
	}

}
