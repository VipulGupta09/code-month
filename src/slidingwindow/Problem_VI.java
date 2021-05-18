package slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

//Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
//https://www.geeksforgeeks.org/longest-sub-array-sum-k/
public class Problem_VI {
	//Sum = K + x
	//Sum - k =x
	
	public static void main(String[] args) {
		int arr[] = {10, 5, 2, 7, 1, 9};
		int k =15;
		int arr2[] = {-5, 8, -14, 2, 4, 12};
		int k2 = -5;
		findLongestSubarray(arr2, k2);
		
		int arr3[]= {-30,10,20,30,40,50,60};
		int k3= 90;
		
		
		
		
	}
	public static void findLongestSubarray(int arr[],int k) {
		int sum = 0;
		int maxLen = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			
			if(sum == k)
				maxLen = i+1;
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
			
			if(map.containsKey(sum-k)) {
				if(maxLen < (i-map.get(sum-k))) {
					maxLen = i-map.get(sum-k);
				}
			}
		}
		System.out.println(maxLen);
	}
	
}
