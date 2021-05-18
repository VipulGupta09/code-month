package com.heap;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindBetween {
	public static void main(String[] args) {
		long arr[] = {1,2,5,7,3};
		long k1 =  2;
		long k2=5;
		sumBetweenTwoKth(arr, 5, k1, k2);
	}

	public static long sumBetweenTwoKth(long a[], long n, long k1, long k2) {
		long start = find(a, k1);
		long end = find(a, k2);
		return sum(a, start, end);
	}

	public static long sum(long arr[], long start, long end) {
		long sum = 0;
		for (long i : arr) {
			if (i > start && i < end) {
				sum += i;
			}
		}
		return sum;
	}

	public static long find(long arr[], long k) {
		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		Set<Long> set = new HashSet<>();
		for (long i : arr)
			set.add(i);

		boolean flag = false;
		for (long i : set) {
			maxHeap.add(i);

			if (maxHeap.size() >=k) {
				maxHeap.poll();
				flag = true;
			}
			// 1 3 5 7 8 9 10
		}
		if(flag==false && k != maxHeap.size())
            return maxHeap.poll()+1;
		return maxHeap.poll();
	}
}
