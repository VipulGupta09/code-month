package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephProblem {
	static int ans = 0;
    static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(safePos(40, 64));
		//System.out.println(find(0, k - 1));
	}

	
    static int safePos(int n, int k) {
        for (int i = 1; i <= n; i++)
			list.add(i);
        return find(0,k-1);
    }
    
  static int find(int i, int k) {
		if (list.size() == 1) {
			return list.get(0);
		}
		int index = (i + k) % list.size();
		list.remove(index);
		return find(index, k);

	}

}
