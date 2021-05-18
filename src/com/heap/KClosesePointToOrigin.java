package com.heap;

import java.util.PriorityQueue;

public class KClosesePointToOrigin {

	public static void main(String[] args) {
		int[][] arr = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		kClosest(arr, k);
	}

	public static int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Kclosest> maxHeap = new PriorityQueue<Kclosest>();
		
		for(int[] arr : points) {
			maxHeap.add(new Kclosest(arr[0], arr[1]));
			
			if(maxHeap.size()>k)
				maxHeap.poll();
		}
		int[][] result = new int[maxHeap.size()][];
		int i =0;
		while(!maxHeap.isEmpty()) {
			Kclosest temp = maxHeap.poll();
			int[] tempArr = new int[2];
			tempArr[0] = temp.x;
			tempArr[1] = temp.y;
			result[i] = tempArr;
			i++;
		}
		return result;
	}
}

class Kclosest implements Comparable<Kclosest>{
	int x;
	int y;
	
	public Kclosest(int x , int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Kclosest o) {
		int tempX = o.x;
		int tempY = o.y;
		int tempHyp = (tempX* tempX) + (tempY*tempY);
		
		int Hyp = (x*x) + (y*y);
		
		if(tempHyp>Hyp)
			return 1;
		return -1;
	}

	@Override
	public String toString() {
		return "Kclosest [x=" + x + ", y=" + y + "]";
	}
	
}
