package com.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequestElement {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 2, 2, 3 }, k = 2;
		find(arr, k);
	}

	public static void find(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
	
		PriorityQueue<Pair1> minHeap = new PriorityQueue<Pair1>();
		
		for(Map.Entry<Integer, Integer> val : map.entrySet()) {
			minHeap.add(new Pair1(val.getValue(), val.getKey()));
			
			if(minHeap.size()>k)
				minHeap.poll();
		}
		
		while(!minHeap.isEmpty())
			System.out.print(minHeap.poll().getVal()+" ");
		
	}

}

class Pair1 implements Comparable<Pair1>{
	int absVal;
	int val;	
	
	public Pair1(int absVal,int val) {
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
	public int compareTo(Pair1 o) {
		return absVal-o.absVal;
	}
	
}

