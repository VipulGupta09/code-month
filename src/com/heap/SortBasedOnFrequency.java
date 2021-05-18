package com.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortBasedOnFrequency {

	public static void main(String[] args) {
		int arr[] ={0,1,2, 5, 2, 8, 5, 6, 8, 8,11,11};
		//find(arr);
		find();
	}
	
	public static void find(int arr[]) {
		Map<Integer, Helper> map = new HashMap<Integer, Helper>();
		
		for(int i = 0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				Helper helper = map.get(arr[i]);
				helper.freq++;
				map.put(arr[i], helper);
			}
			else {
				Helper helper = new Helper(1, i,arr[i]);
				map.put(arr[i], helper);
			}
		}
		
		PriorityQueue<Helper> maxHeap = new PriorityQueue<Helper>();
		for(Map.Entry<Integer, Helper> entry : map.entrySet()) {
			maxHeap.add(new Helper(entry.getValue().freq, entry.getValue().index, entry.getValue().key));
		}
		
		while(!maxHeap.isEmpty()) {
			Helper helper = maxHeap.poll();
			int freq = helper.freq;
			while(freq>0) {
				System.out.print(helper.key+" ");
				freq--;
			}
		}
	
		
	}
	
	public static void find() {
		List<Helper>  list = new ArrayList<Helper>();
		Helper h1 = new Helper(2, 1, 3);
		Helper h2 = new Helper(4, 1, 3);
		Helper h3 = new Helper(9, 1, 3);
		Helper h4 = new Helper(7, 1, 3);
		
		
		list.add(new Helper(2, 1, 3));
		list.add(new Helper(4, 1, 3));
		list.add(h3);
		list.add(h4);
		Collections.sort(list);
		
		System.out.println(list);
		
		
	}
}

class Helper implements Comparable<Helper>{
	Integer key;
	Integer freq;
	Integer index;
	
	public Helper(Integer freq,Integer index,Integer key) {
		this.freq = freq;
		this.index = index;
		this.key = key;
	}


	@Override
	public String toString() {
		return "Helper [ freq=" + freq + ", index=" + index + ", key=" + key +"]";
	}


	@Override
	public int compareTo(Helper o2) {
		System.out.println("hello");
		if(o2.freq > freq)
			return 1;
		else if(o2.freq <freq)
			return -1;
		else if(o2.index <index )
			return 1;
		return -1;
	}
}

// 1. first in first out
// 2. first in last out
// 3. 

// 1 2 3 4 5
// int size =  16; 16*2

// index =0
// enqueIndex++;
// arr[] ={1,2,3,4,5,6,7,8}

//deque
// arr[] ={}



