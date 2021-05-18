package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Smallest_Element {
	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 3, 20, 15 };
		int k = 3; // 3,4,7,10,15,20 // 7
		// find(arr, k);
		// find_K_Largest_Ele(arr, k);

		int nearlySortedArr[] = { 6, 5, 3, 2, 8, 10, 9 };
		//Sort_K_Sorted_Array(nearlySortedArr, 3);

	}
	
	public static void find(int arr[], int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		int i = 0;
		while (i < arr.length) {
			heap.add(arr[i]);
			if (heap.size() > k)
				heap.poll();
			i++;
		}
		System.out.println(heap.poll());
	}

	public static void find_K_Largest_Ele(int arr[], int k) {
		int i = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		while (i < arr.length) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k)
				minHeap.poll();
			i++;
		}
		System.out.println(minHeap);
	}

	public static void Sort_K_Sorted_Array(int[] arr, int k) {
		int i = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		while (i < arr.length) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k)
				System.out.print(minHeap.poll() + " ");
			i++;
		}
		while (!minHeap.isEmpty())
			System.out.print(minHeap.poll() + " ");
	}

	
}


