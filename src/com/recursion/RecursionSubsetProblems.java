package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RecursionSubsetProblems {
	static ArrayList<String> list = new ArrayList<String>();
	static Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

	public static void main(String[] args) {

		int N = 4, arr[] = { 1, 2, 3, 3 };
		AllSubsets(arr, N);

		String str = "abc";
		// findAllSubsets(str,"");
		// Collections.sort(list);
		// System.out.println(list);
	}

	public static void findAllSubsets(String str, String output) {
		if (str.length() == 0) {
			list.add(output.trim());
			return;
		}

		String output1 = output;
		String output2 = output;

		output2 = output2 + str.charAt(0);

		str = str.substring(1, str.length());
		findAllSubsets(str, output1);
		findAllSubsets(str, output2);
	}

	// 1 2 3 3
	public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
		String str = "";
		for(int i : arr)
			str= str+i;
		
		Set<String> set = new HashSet<String>();
		
		
		findAllUniqueSubsets(str, "", set);
	
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(String s: set) {
			ArrayList<Integer> listTemp = new ArrayList<Integer>();
			for(int i = 0;i<s.length();i++) {
				listTemp.add(s.charAt(i)-'0');
			}
			Collections.sort(listTemp);
			list.add(listTemp);
		}
		System.out.println(list);
		//[, 33, 23, 1, 133, 12, 2, 233, 13, 123, 3, 1233]
		//(),(1),(1 2),(1 2 3) (1 2 3 3),(1 3),(1 3 3),(2),(2 3)(2 3 3),(3),(3 3)
		return null;
	}
	
	public static Set<String> findAllUniqueSubsets(String str, String output,Set<String> set){
		if(str.length() == 0) {
			set.add(output.trim());
			return set;
		}
		String output1 = output;
		String output2 = output;
		output2 = output2+str.charAt(0);
		
		str = str.substring(1, str.length());
		findAllUniqueSubsets(str, output1, set);
		findAllUniqueSubsets(str, output2, set);
		return set;
	}

}
