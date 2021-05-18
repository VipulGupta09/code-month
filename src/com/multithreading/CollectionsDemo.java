package com.multithreading;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class CollectionsDemo {
	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet(new MyComparator());
		treeSet.add("A");
		treeSet.add("AA");
		treeSet.add("Z");
		treeSet.add("ZZ");
		treeSet.add("XX");
		treeSet.add("Y");
		treeSet.add("XY");
		treeSet.add("ABCD");
		treeSet.add("ABC");
		
		System.out.println(treeSet);
			
	}
}

class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String)o1;
		String s2 = (String)o2;
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1<l2) {
			return -1;
		}
		else if(l1>l2) {
			return 1;
		}
		else{
			return s1.compareTo(s2);
		}
	}
	
}
